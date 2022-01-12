package com.til.data.di

import com.hmju.loginmanager.LoginManager
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.til.data.NetworkConfig
import com.til.data.interceptor.HeaderInterceptor
import com.til.data.interceptor.TokenAuthenticator
import com.til.data.network.AuthApiService
import com.til.data.network.GoodsApiService
import com.til.data.qualifiers.HeaderJsonInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
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
    fun provideTokenAuthenticator(
        loginManager: LoginManager,
        authApiService: AuthApiService
    ) = TokenAuthenticator(loginManager,authApiService)

    @Singleton
    @Provides
    @HeaderJsonInterceptor
    fun provideHeaderInterceptor(loginManager: LoginManager) = HeaderInterceptor(loginManager)

    @Singleton
    @Provides
    fun provideHttpClient(
        @HeaderJsonInterceptor headerInterceptor: HeaderInterceptor,
        tokenAuthenticator: TokenAuthenticator
    ) = OkHttpClient.Builder().apply {
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

    @Singleton
    @Provides
    fun provideJsonFormat() = Json {
        isLenient = true // Json 큰따옴표 느슨하게 체크.
        ignoreUnknownKeys = true // Field 값이 없는 경우 무시
        coerceInputValues = true // "null" 이 들어간경우 default Argument 값으로 대체
    }

    @ExperimentalSerializationApi
    @Singleton
    @Provides
    fun provideRetrofit(httpClient : OkHttpClient, json: Json) =
        Retrofit.Builder().apply {
            baseUrl(NetworkConfig.BASE_URL)
            client(httpClient)
            addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
            addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        }

    @Singleton
    @Provides
    fun provideGoodsApiService(retrofit: Retrofit) = retrofit.create(GoodsApiService::class.java)

    @Singleton
    @Provides
    fun provideAuthApiService(retrofit: Retrofit) = retrofit.create(AuthApiService::class.java)

}