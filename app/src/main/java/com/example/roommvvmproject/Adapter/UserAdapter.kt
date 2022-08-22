package com.example.roommvvmproject.Adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roommvvmproject.R
import com.example.roommvvmproject.data.User
import kotlinx.android.synthetic.main.add_dialog_box.*
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class UserAdapter(private val context: Context,private val onClickItem: OnClickItem) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var arrUser = ArrayList<User>()
    class ViewHolder(itemView: View,onClickItem: OnClickItem) : RecyclerView.ViewHolder(itemView) {
        fun bind(info: User) {
            itemView.name.text = info.name
            itemView.number.text = info.number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recyclerview_row, parent, false),onClickItem
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pos = arrUser[position]
        holder.bind(pos)
        holder.itemView.delete.setOnClickListener {
            onClickItem.deleteRow(arrUser.get(position),position)
        }

    }

    override fun getItemCount(): Int {
        return arrUser.size
    }

    fun updateUserList(user: List<User>) {
        arrUser.clear()
        arrUser.addAll(user)
        notifyDataSetChanged()
    }
    interface OnClickItem{
        fun deleteRow(user: User,position: Int)
    }
}

