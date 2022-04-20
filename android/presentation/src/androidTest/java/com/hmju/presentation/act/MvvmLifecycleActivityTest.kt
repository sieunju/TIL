package com.hmju.presentation.act

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hmju.presentation.mvvm_lifecycle.MvvmLifecycleTestActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Description :
 *
 * Created by juhongmin on 2022/04/20
 */
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class MvvmLifecycleActivityTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun testAct() {
        launchActivity<MvvmLifecycleTestActivity>().apply {
            moveToState(Lifecycle.State.RESUMED)
        }
        Thread.sleep(10_000)
    }
}
