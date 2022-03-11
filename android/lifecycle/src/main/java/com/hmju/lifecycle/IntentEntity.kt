package com.hmju.lifecycle

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

/**
 * Description : ViewModel 에서
 * Activity StartActivity, StartActivityResult 하기위한 데이터 모델 클래스
 *
 * Created by juhongmin on 2022/03/11
 */
data class IntentEntity(
    val target: Class<out FragmentActivity>,
    val bundle: Bundle? = null,
    val flags: Int? = null,
    val requestCode: Int? = null
)
