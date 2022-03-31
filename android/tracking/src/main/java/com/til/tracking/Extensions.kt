package com.til.tracking

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

/**
 * Description :
 *
 * Created by juhongmin on 2022/03/31
 */
@SuppressLint("SimpleDateFormat")
object Extensions {

    private val minDate = SimpleDateFormat("HH:mm:ss")

    fun Long.toDate(): String {
        return minDate.format(this)
    }
}