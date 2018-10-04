package com.example.chinedunweze.androidsample

import android.app.Application
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley


class MyApplication : Application() {

    init {
        myApplication = this
    }

    companion object {
        private val TAG = MyApplication::class.java.simpleName
        private lateinit var myApplication: MyApplication

        fun appContext(): MyApplication {
            return myApplication
        }
    }

    private var requestQueue: RequestQueue? = null

    override fun onCreate() {
        super.onCreate()
        myApplication = this
    }

    fun getRequestQueue(): RequestQueue? {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(applicationContext)
        }
        return requestQueue
    }


    fun <T> addToRequestQueue(req: Request<T>) {
        req.setTag(TAG)
        getRequestQueue()?.add(req)
    }
}