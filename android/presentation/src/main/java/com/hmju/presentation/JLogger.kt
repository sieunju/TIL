package com.hmju.presentation

import android.util.Log

class JLogger {
    companion object {
        const val TAG = "JLogger"
        fun d(msg: String) {
            Log.d(TAG, msg)
        }

        fun e(msg: String) {
            Log.e(TAG, msg)
        }
    }
}