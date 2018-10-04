package com.example.chinedunweze.androidsample.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.chinedunweze.androidsample.model.DataViewModel
import com.example.chinedunweze.androidsample.R
import com.example.chinedunweze.androidsample.UserAdapter
import com.example.chinedunweze.androidsample.data.Data
import com.example.chinedunweze.androidsample.util.Utils
import kotlinx.android.synthetic.main.first_screen_layout.*

class FirstScreenActivity : AppCompatActivity() {

    companion object {
        private val TAG = FirstScreenActivity::class.java.simpleName
    }


    private lateinit var dataViewModel: DataViewModel
    private val dataAdapter: UserAdapter = UserAdapter(this, arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_screen_layout)

        // Get the ViewModel
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = dataAdapter

        // Create the observer that updates the recycler view with data
        val dataObserver = Observer<ArrayList<Data>> { data ->
            if (data != null && data.isNotEmpty()) {
                recyclerview.visibility = View.VISIBLE
                empty_view.visibility = View.GONE
                dataAdapter.updateData(data)
            } else {
                recyclerview.visibility = View.GONE
                empty_view.visibility = View.VISIBLE
            }
        }

        if (Utils.isNetworkAvailable(this)) {
            // Observe the LiveData, passing in this Activity as the LifecyleOwner and the Observer
            dataViewModel.getUsers().observe(this, dataObserver)
        } else {
            Toast.makeText(this, getString(R.string.no_data_connectivity), Toast.LENGTH_LONG).show()
        }

    }
}
