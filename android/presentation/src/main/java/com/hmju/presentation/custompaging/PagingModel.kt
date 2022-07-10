package com.hmju.presentation.custompaging

/**
 * Description : 페이징 처리 관련 데이터 모델
 * @param isLoading 로드 API 중인지 유무
 * @param isLast 더이상 페이징처리를 할수 없는 상태인지 유무 Flag
 * Created by juhongmin on 2022/01/21
 */
data class PagingModel(
    var isLoading: Boolean = true,
    var isLast: Boolean = false
)
