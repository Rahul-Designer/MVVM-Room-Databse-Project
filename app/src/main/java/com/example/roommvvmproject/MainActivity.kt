package com.example.roommvvmproject

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roommvvmproject.Adapter.UserAdapter
import com.example.roommvvmproject.Model.UserViewModel
import com.example.roommvvmproject.Model.UserViewModelFactory
import com.example.roommvvmproject.data.User
import com.example.roommvvmproject.data.UserDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_box.*

class MainActivity : AppCompatActivity(),UserAdapter.OnClickItem {
    lateinit var userViewModel: UserViewModel
    lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user_recyclerview.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter(this,this)
        user_recyclerview.adapter = adapter

        val dao = UserDatabase.getDatabase(applicationContext).userDao()
        val repository = UserRepository(dao)
        userViewModel =
            ViewModelProvider(this, UserViewModelFactory(repository)).get(UserViewModel::class.java)

        userViewModel.getUser().observe(this, Observer {
            adapter.updateUserList(it)
        })


        add.setOnClickListener{
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_box,null)
            val builder = AlertDialog.Builder(this)
                .setView(mDialogView)
            val mAlterDialog = builder.show()
            mAlterDialog.addUser.setOnClickListener{
                mAlterDialog.dismiss()
                val inputName = mAlterDialog.userName.text.toString()
                val inputNumber = mAlterDialog.userNumber.text.toString()
                userViewModel.insertUser(User(null,inputName,inputNumber))
            }
        }
    }

    override fun deleteRow(position: Int) {
//        userViewModel.deleteUser()
//        adapter.notifyItemChanged(position)
    }
}