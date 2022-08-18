package com.example.roommvvmproject.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roommvvmproject.R
import com.example.roommvvmproject.data.User
import kotlinx.android.synthetic.main.recyclerview_row.view.name
import kotlinx.android.synthetic.main.recyclerview_row.view.number

class UserAdapter(private val context: Context) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    var arrUser = ArrayList<User>()
    fun setListData(data : ArrayList<User>){
        this.arrUser = data
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(info: User) {
            itemView.name.text = info.name
            itemView.number.text = info.number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recyclerview_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pos = arrUser[position]
        holder.bind(pos)
    }

    override fun getItemCount(): Int {
        return arrUser.size
    }
}

