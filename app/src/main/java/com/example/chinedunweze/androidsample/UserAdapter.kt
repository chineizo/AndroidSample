package com.example.chinedunweze.androidsample

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chinedunweze.androidsample.data.Data
import com.example.chinedunweze.androidsample.util.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.first_screen_item_layout.view.*

/**
 * Adapter class to manages the display of Users in a Recycler View
 */
class UserAdapter(private val context: Context, private val items: ArrayList<Data>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    companion object {
        private val TAG = UserAdapter::class.java.simpleName
    }

    private var dataList = items;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.first_screen_item_layout, parent, false))
                .listen { position, type ->
                    val item = dataList[position]
                    Log.d(TAG, "Item clicked:" + item.fullName)
                    launchDetailsActivity(item)
                }
    }

    private fun launchDetailsActivity(data: Data) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra(Constants.ACTION_SEND_DATA, data)
        context.startActivity(intent)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.name.text = data.name
        holder.ownerName.text = data.fullName
        Picasso.with(context).load(data.owner?.avatarUrl).into(holder.avatar)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.name
        val ownerName = view.owner_name
        val avatar = view.avatar
    }

    fun updateData(data: ArrayList<Data>) {
        dataList = data
        notifyDataSetChanged()
    }

    /**
     * Extension for this View Holder to listen for events
     */
    fun <T : ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(adapterPosition, itemViewType)
        }
        return this
    }
}