package com.til.tracking

import android.app.Activity
import android.app.Application
import android.os.Bundle
import java.lang.ref.WeakReference

/**
 * Description : HTTP 트레킹 매니저
 *
 * Created by juhongmin on 2022/03/29
 */
object TrackingManager {
    lateinit var applicationContext: Application

    private val activityListener = object : Application.ActivityLifecycleCallbacks {
        var currentActivity: WeakReference<Activity>? = null

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

        override fun onActivityStarted(activity: Activity) {}

        override fun onActivityResumed(activity: Activity) {
            currentActivity?.clear()
            currentActivity = WeakReference(activity)
        }

        override fun onActivityPaused(activity: Activity) {}

        override fun onActivityStopped(activity: Activity) {
            currentActivity?.clear()
            currentActivity = null
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

        override fun onActivityDestroyed(activity: Activity) {}
    }

    fun init(context: Application) {
        applicationContext = context
        context.registerActivityLifecycleCallbacks(activityListener)
    }
}
