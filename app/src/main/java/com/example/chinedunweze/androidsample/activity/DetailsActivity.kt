package com.example.chinedunweze.androidsample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.chinedunweze.androidsample.R
import com.example.chinedunweze.androidsample.data.Data
import com.example.chinedunweze.androidsample.util.Constants
import kotlinx.android.synthetic.main.second_screen_layout.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen_layout)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val data = intent.getSerializableExtra(Constants.ACTION_SEND_DATA) as Data
        updateView(data)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Display Data items in the view
     */
    fun updateView(data: Data?) {
        open_issues.text = data?.openIssues.toString()
        forks.text = data?.forks.toString()
        watchers.text = data?.watchers.toString()
        project_id.text = data?.id
        last_update_date.text = data?.lastUpdate
        creation_date.text = data?.creationDate
        repository_url.text = data?.url
        name.text = data?.name
        owner_name.text = data?.fullName
    }
}