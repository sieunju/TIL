package com.til.rxhandling.adapter

import com.til.model.base.JSendSimpleResponse
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import timber.log.Timber
import java.lang.reflect.Type
import java.util.concurrent.ConcurrentHashMap

/**
 * Description :
 *
 * Created by juhongmin on 2022/05/14
 */
@OptIn(ExperimentalSerializationApi::class)
class RxJSendConverterFactory(
    private val contentType: MediaType
) : Converter.Factory() {

    private val format: Json by lazy {
        Json {
            isLenient = true // Json 큰따옴표 느슨하게 체크.
            ignoreUnknownKeys = true // Field 값이 없는 경우 무시
            coerceInputValues = true // "null" 이 들어간경우 default Argument 값으로 대체
        }
    }


    override fun responseBodyConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *> {
        val loader = format.serializersModule.serializer(type)
        val rawType = getRawType(type)
        Timber.d("RawType $rawType")
        return DeserializationConverter(rawType, loader, format)
    }

    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<out Annotation>,
        methodAnnotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<*, RequestBody> {
        val saver = format.serializersModule.serializer(type)
        return SerializationConverter(contentType, saver, format)
    }

    /**
     * Response 역 직렬화 컨버터
     */
    class DeserializationConverter<T>(
        private val rawType: Class<*>,
        private val loader: DeserializationStrategy<T>,
        private val format: Json
    ) : Converter<ResponseBody, T> {
        override fun convert(value: ResponseBody): T? {
            val string = value.string()
            if (rawType.isAnnotationPresent(JSendSimpleResponse::class.java)) {
                Timber.d("JSendSimpleResponse 가 있습니다. ")
                val jsonElement = format.decodeFromString<JsonElement>(string)
                val dataBody =
                    jsonElement.jsonObject["data"] ?: return format.decodeFromString(loader, string)

                val status = jsonElement.jsonObject["status"]
                val message = jsonElement.jsonObject["message"]
                val payload = dataBody.jsonObject["payload"]
                val meta = dataBody.jsonObject["meta"]
                val map = ConcurrentHashMap<String, JsonElement>()
                if (status != null) {
                    map["status"] = status
                }
                if (message != null) {
                    map["message"] = message
                }
                if (payload != null) {
                    map["payload"] = payload
                }
                if (meta != null) {
                    map["meta"] = meta
                }
                val json = JsonObject(map)
                Timber.d("재 가공 데이터 ${json}")
                return format.decodeFromString(loader, json.toString())
            } else {
                Timber.d("JSendSimpleResponse 가 없습니다. ")
                return format.decodeFromString(loader, string)
            }
        }
    }

    /**
     * Request 직렬화 컨버터
     */
    class SerializationConverter<T>(
        private val contentType: MediaType,
        private val saver: SerializationStrategy<T>,
        private val format: Json
    ) : Converter<T, RequestBody> {
        override fun convert(value: T): RequestBody {
            val string = format.encodeToString(saver, value)
            return string.toRequestBody(contentType)
        }
    }
}