package com.til.rxhandling

/**
 * Description : HTTP Base Response
 *
 * Created by juhongmin on 2022/05/14
 */
sealed class ApiResponse<out T : Any> {
    // HTTP Success 200 .. 299 (Builder 패턴으로 성공 코드에 대한 범위를 변경할수 있다.)
    data class Success<T : Any>(val body: T) : ApiResponse<T>()

    // 그웨엔 실패로 간주
    data class Failure(val code: Int, val error: String?) : ApiResponse<Nothing>()

    // Time Out 이라던지 정의되지 않는 에러들
    data class Unexpected(val t: Throwable?) : ApiResponse<Nothing>()
}