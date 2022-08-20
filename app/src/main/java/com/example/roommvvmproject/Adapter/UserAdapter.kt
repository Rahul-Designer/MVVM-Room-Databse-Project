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

    private val arrUser = ArrayList<User>()
    class ViewHolder(itemView: View,onClickItem: OnClickItem) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.delete.setOnClickListener {
                onClickItem.deleteRow(adapterPosition)
            }
        }
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

    }

    override fun getItemCount(): Int {
        return arrUser.size
    }

    fun updateUserList(it: List<User>?) {
        arrUser.clear()
        if (it != null) {
            arrUser.addAll(it)
        }
        notifyDataSetChanged()
    }
    interface OnClickItem{
        fun deleteRow(position: Int)
    }
}

