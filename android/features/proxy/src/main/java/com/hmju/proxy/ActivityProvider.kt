package com.hmju.proxy

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.FragmentActivity
import kotlin.reflect.KClass

/**
 * Description : 액티비티간 연결 해주는 제공자
 *
 * Created by juhongmin on 2022/07/12
 */
interface ActivityProvider {
    fun moveToActivity(targetActivity: KClass<out FragmentActivity>)
    fun moveToActivity(targetActivity: KClass<out FragmentActivity>, flags: Int)
    fun moveToActivity(targetActivity: KClass<out FragmentActivity>, flags: Int, data: Bundle)
    fun moveToActivity(
        activityResult: ActivityResultLauncher<Intent>,
        targetActivity: KClass<out FragmentActivity>,
        flags: Int,
        data: Bundle
    )
}
