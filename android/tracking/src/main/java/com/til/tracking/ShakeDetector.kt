package com.til.tracking

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import timber.log.Timber


/**
 * Description : 쉐이크 감지 클래스
 *
 * Created by juhongmin on 2022/03/30
 */
internal class ShakeDetector : SensorEventListener {

    companion object {
        // 중력, 중력가속도을 기준으로 삼아서 진동, 움직임을 측정한다.
        // 흔들림 감지할 때 기준이 되는 가해지는 힘
        const val SHAKE_THRESHOLD_GRAVITY = 2.7f
        const val SHAKE_SLOP_TIME_MS = 500
        const val SHAKE_COUNT_RESET_TIME_MS = 1000
    }

    private var shakeTimeStamp : Long = 0L
    private var shakeCnt : Int = 0

    interface OnShakeListener {
        fun onShowDialog()
    }

    private var listener : OnShakeListener? = null

    fun setListener (listener : OnShakeListener) : ShakeDetector {
        this.listener = listener
        return this
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // ignore
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(event == null) return

        // x,y,z 축의 값을 받아온다
        // x,y,z 축의 값을 받아온다
        val x = event.values[0]
        val y = event.values[1]
        val z = event.values[2]
        // 중력 가속도값으로 나눈 값으로 만든다
        // 중력 가속도값으로 나눈 값으로 만든다
        val gX = x / SensorManager.GRAVITY_EARTH
        val gY = y / SensorManager.GRAVITY_EARTH
        val gZ = z / SensorManager.GRAVITY_EARTH
        // gforce는 중력가속도를 포함하는 물체가 받는 힘
        // 1일때는 평소에 받는 중력(정지)
        // 1이하일때(아래로 떨어지며 힘을 덜받을 때)
        // 1이상일 때(위로 올라가면서 힘을 더 받을 때)
        // 단순히 힘의 크기를 계산하기 때문에 피타고라스로 구한다
        // gForce will be close to 1 when there is no movement.
        // gforce는 중력가속도를 포함하는 물체가 받는 힘
        // 1일때는 평소에 받는 중력(정지)
        // 1이하일때(아래로 떨어지며 힘을 덜받을 때)
        // 1이상일 때(위로 올라가면서 힘을 더 받을 때)
        // 단순히 힘의 크기를 계산하기 때문에 피타고라스로 구한다
        // gForce will be close to 1 when there is no movement.
        val gForce = Math.sqrt((gX * gX + gY * gY + gZ * gZ).toDouble()).toFloat()
        // 진동을 감지했을 때
        // gforce가 기준치 이상일 경우
        // 진동을 감지했을 때
        // gforce가 기준치 이상일 경우
        if (gForce > SHAKE_THRESHOLD_GRAVITY) {
            val now = System.currentTimeMillis()
            // 진동 간격이 너무 짧을 때는 무시
            // ignore shake events too close to each other (500ms)
            if (shakeTimeStamp + SHAKE_SLOP_TIME_MS > now) {
                return
            }
            // 3초 이상 걸렸을 때 reset한다
            // reset the shake count after 3 seconds of no shakes
            if (shakeTimeStamp + SHAKE_COUNT_RESET_TIME_MS < now) {
                shakeCnt = 0
            }
            // 업데이트한다
            shakeTimeStamp = now
            shakeCnt++
            // 흔들렸을 때 행동을 설정한다
            if(shakeCnt > 0) {
                listener?.onShowDialog()
            }
        }
    }
}
