package com.til.data.di

import com.hmju.loginmanager.LoginManager
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.til.data.NetworkConfig
import com.til.data.interceptor.HeaderInterceptor
import com.til.data.interceptor.TokenAuthenticator
import com.til.data.network.AuthApiService
import com.til.data.network.GoodsApiService
import com.til.data.network.RefreshTokenApiService
import com.til.data.qualifiers.ApiHttpClient
import com.til.data.qualifiers.HeaderJsonInterceptor
import com.til.data.qualifiers.TokenHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Description : 데이터 모듈 DI
 *
 * Created by juhongmin on 2022/01/11
 */
@InstallIn(SingletonComponent::class)
@Module
internal object RemoteModule {

    @Singleton
    @Provides
    fun provideJsonFormat(): Json = Json {
        isLenient = true // Json 큰따옴표 느슨하게 체크.
        ignoreUnknownKeys = true // Field 값이 없는 경우 무시
        coerceInputValues = true // "null" 이 들어간경우 default Argument 값으로 대체
    }

    @Singleton
    @Provides
    @HeaderJsonInterceptor
    fun provideHeaderInterceptor(
        loginManager: LoginManager
    ): Interceptor = HeaderInterceptor(loginManager)

    @Singleton
    @Provides
    @TokenHttpClient
    fun provideTokenHttpClient(
        @HeaderJsonInterceptor headerInterceptor: Interceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .retryOnConnectionFailure(true)
        .connectTimeout(NetworkConfig.CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
        .readTimeout(NetworkConfig.READ_TIME_OUT, TimeUnit.MILLISECONDS)
        .writeTimeout(NetworkConfig.WRITE_TIME_OUT, TimeUnit.MILLISECONDS)
        .addNetworkInterceptor(headerInterceptor)
        .build()

    @ExperimentalSerializationApi
    @Singleton
    @Provides
    fun provideRefreshTokenApiService(
        @TokenHttpClient httpClient: OkHttpClient,
        json: Json
    ): RefreshTokenApiService = Retrofit.Builder()
        .baseUrl(NetworkConfig.BASE_URL)
        .client(httpClient)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build().create(RefreshTokenApiService::class.java)

    @Singleton
    @Provides
    fun provideTokenAuthenticator(
        loginManager: LoginManager,
        apiService: RefreshTokenApiService
    ): Authenticator = TokenAuthenticator(loginManager, apiService)

    @Singleton
    @Provides
    @ApiHttpClient
    fun provideHttpClient(
        @HeaderJsonInterceptor headerInterceptor: Interceptor,
        tokenAuthenticator: Authenticator
    ): OkHttpClient = OkHttpClient.Builder().apply {
        retryOnConnectionFailure(true)
        connectTimeout(NetworkConfig.CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
        readTimeout(NetworkConfig.READ_TIME_OUT, TimeUnit.MILLISECONDS)
        writeTimeout(NetworkConfig.WRITE_TIME_OUT, TimeUnit.MILLISECONDS)
        addNetworkInterceptor(headerInterceptor)
        authenticator(tokenAuthenticator)
        addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
    }.build()

    @ExperimentalSerializationApi
    @Provides
    fun provideRetrofit(
        @ApiHttpClient httpClient: OkHttpClient,
        json: Json
    ): Retrofit = Retrofit.Builder().apply {
        baseUrl(NetworkConfig.BASE_URL)
        client(httpClient)
        addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
        addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    }.build()

    // [s] Main API Service
    @Singleton
    @Provides
    fun provideGoodsApiService(
        retrofit: Retrofit
    ): GoodsApiService = retrofit.create(GoodsApiService::class.java)

    @Singleton
    @Provides
    fun provideAuthApiService(
        retrofit: Retrofit
    ): AuthApiService = retrofit.create(AuthApiService::class.java)
    // [e] Main API Service
}
