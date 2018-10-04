package com.example.chinedunweze.androidsample.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.chinedunweze.androidsample.MyApplication
import com.example.chinedunweze.androidsample.data.Data
import com.example.chinedunweze.androidsample.util.Constants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataViewModel : ViewModel() {

    companion object {
        private val TAG = DataViewModel::class.java.simpleName
    }

    // Create a LiveData with a List of Data
    private lateinit var currentDataList: MutableLiveData<ArrayList<Data>>

    /**
     * Method to return list of Users from the API request
     */
    fun getUsers(): LiveData<ArrayList<Data>> {
        if (!::currentDataList.isInitialized) {
            currentDataList = MutableLiveData()
            loadUsers()
        }
        return currentDataList
    }

    /**
     * Contact API to return list of Users
     */
    private fun loadUsers() {
        val stringRequest = StringRequest(Request.Method.GET, Constants.URL,
                Response.Listener<String> { response ->
                    currentDataList.value = Gson().fromJson(response, object : TypeToken<ArrayList<Data>>() {}.type)
                    Log.d(TAG, "Size of data Returned: " + currentDataList.value?.size)
                },
                Response.ErrorListener {
                    Log.e(TAG, "Error occurred contacting API Service:" + it.networkResponse)
                })

        // Add the request to the RequestQueue.
        MyApplication.appContext().addToRequestQueue(stringRequest)
    }

}