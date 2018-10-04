package com.example.chinedunweze.androidsample.util

import android.content.Context
import android.net.ConnectivityManager


class Utils {
    companion object {
        /**
         * Check for Data connectivity
         */
        fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            val activeNetworkInfo = connectivityManager!!.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }
    }
}