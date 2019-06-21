package com.example.roomdbsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdbsample.adapter.ContactListAdapter
import com.example.roomdbsample.db.ContactInfoDB
import com.example.roomdbsample.entity.ContactInfoEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contactInfoDB = ContactInfoDB.getInstance(this)

        val contactInfoDao = contactInfoDB?.getContactInfoDao()

        with(recyclerTodoList){
            adapter = ContactListAdapter{contactInfoEntity ->
                thread (start = true){
                    contactInfoDao?.removeItem(contactInfoEntity)
                }
            }
            layoutManager= LinearLayoutManager(this@MainActivity)
        }

        contactInfoDao?.getAllList()?.observe(this, Observer<List<ContactInfoEntity>>{_newContactList ->
            (recyclerTodoList.adapter as ContactListAdapter).setNewItem(_newContactList)
        })


        val contactInfoEntity = ContactInfoEntity(
                phoneNumber = "5423453421",
                contactName = "Bugra",
                contactAge = 25,
                contactEmail = "bgraknd@gmail.com"
        )

        val contactInfoEntity2 = ContactInfoEntity(
                phoneNumber = "5423453421",
                contactName = "Emirhan",
                contactAge = 25,
                contactEmail = "bgraknd@gmail.com"
        )

        thread(start = true) {
                contactInfoDao?.addNewItem(contactInfoEntity)
                contactInfoDao?.addNewItem(contactInfoEntity2)

        }
        }
    }

