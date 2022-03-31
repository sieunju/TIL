package com.til.tracking

import android.app.Activity
import android.app.Application
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.til.tracking.entity.TrackingHttpEntity
import com.til.tracking.ui.TrackingBottomSheetDialog
import timber.log.Timber
import java.lang.ref.WeakReference

/**
 * Description : HTTP 트레킹 매니저
 *
 * Created by juhongmin on 2022/03/29
 */
class TrackingManager private constructor() {

    companion object {
        @Volatile
        private var instance: TrackingManager? = null

        @JvmStatic
        fun getInstance(): TrackingManager {
            return instance ?: synchronized(this) {
                instance ?: TrackingManager().also {
                    instance = it
                }
            }
        }
    }

    // [s] Variable
    private var isDebug = false
    private var logMaxSize = 100
    // [e] Variable

    private var applicationContext: Application? = null
    private val httpTrackingList: MutableList<TrackingHttpEntity> by lazy { mutableListOf() }

    private val activityListener = object : Application.ActivityLifecycleCallbacks {
        var currentActivity: WeakReference<FragmentActivity>? = null

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

        override fun onActivityStarted(activity: Activity) {}

        override fun onActivityResumed(activity: Activity) {
            if (activity is FragmentActivity) {
                currentActivity?.clear()
                currentActivity = WeakReference(activity)
            }
        }

        override fun onActivityPaused(activity: Activity) {}

        override fun onActivityStopped(activity: Activity) {
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

        override fun onActivityDestroyed(activity: Activity) {}
    }

    private val trackingBottomSheetDialog: TrackingBottomSheetDialog by lazy { TrackingBottomSheetDialog() }

    private val shakeListener = object : ShakeDetector.OnShakeListener {
        override fun onShowDialog() {
            activityListener.currentActivity?.get()?.let { act ->
                Timber.d("ShowDialog ${trackingBottomSheetDialog.isVisible}")
                if (trackingBottomSheetDialog.isVisible) {
                    trackingBottomSheetDialog.dismiss()
                }
                trackingBottomSheetDialog.show(
                    act.supportFragmentManager,
                    "TrackingBottomSheetDialog"
                )
            }
        }
    }

    private val shakeDetector: ShakeDetector by lazy { ShakeDetector().setListener(shakeListener) }

    fun init(context: Application): TrackingManager {
        applicationContext = context
        context.registerActivityLifecycleCallbacks(activityListener)
        val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(
            shakeDetector,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_UI
        )
        return this
    }

    fun setBuild(isDebug: Boolean): TrackingManager {
        this.isDebug = isDebug
        return this
    }

    fun setLogMaxSize(size: Int): TrackingManager {
        this.logMaxSize = size
        return this
    }

    fun isDebug() = isDebug

    fun isRelease() = !isDebug

    fun addTracking(entity: TrackingHttpEntity?) {
        if (entity == null) return
        httpTrackingList.add(entity)
        // 맥스 사이즈 맨 첫번째꺼 삭제
        if (logMaxSize > httpTrackingList.size) {
            httpTrackingList.removeFirst()
        }
        Timber.d("Tracking $entity")
    }
}
