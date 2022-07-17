package com.hmju.proxy.impl

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.FragmentActivity
import com.hmju.proxy.ActivityProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlin.reflect.KClass

/**
 * Description : 액티비티간 연결 해주는 제공자 구현체 클래스
 *
 * Created by juhongmin on 2022/07/13
 */
internal class ActivityProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ActivityProvider {
    override fun moveToActivity(targetActivity: KClass<out FragmentActivity>) {
        moveToActivity(targetActivity, -1)
    }

    override fun moveToActivity(targetActivity: KClass<out FragmentActivity>, flags: Int) {
        moveToActivity(targetActivity, flags, Bundle())
    }

    override fun moveToActivity(
        targetActivity: KClass<out FragmentActivity>,
        flags: Int,
        data: Bundle
    ) {
        Intent(context, targetActivity::class.java).apply {
            if (flags != -1) {
                setFlags(flags)
            }
            putExtras(data)
            context.startActivity(this)
        }
    }

    override fun moveToActivity(
        activityResult: ActivityResultLauncher<Intent>,
        targetActivity: KClass<out FragmentActivity>,
        flags: Int,
        data: Bundle
    ) {
        Intent(context, targetActivity::class.java).apply {
            if (flags != -1) {
                setFlags(flags)
            }
            putExtras(data)
            activityResult.launch(this)
        }
    }
}
