package com.example.roomdbsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbsample.R
import com.example.roomdbsample.entity.ContactInfoEntity

/**
 * Created by Bugra on 21.04.2019 - 12:44
 */

class ContactListViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_contact_list,parent,false))

{
    private val  txtPhoneNumber : TextView by lazy { itemView.findViewById<TextView>(R.id.txtPhoneNumber) }
    private val  txtContactName: TextView by lazy { itemView.findViewById<TextView>(R.id.txtContactName) }
    private val  txtContactAge: TextView by lazy { itemView.findViewById<TextView>(R.id.txtContactAge) }
    private val  txtContactEmail: TextView by lazy { itemView.findViewById<TextView>(R.id.txtContactEmail) }

    fun bind(contactInfoEntity: ContactInfoEntity, onClickListener: (contactInfoEntity:ContactInfoEntity)->Unit){
        txtPhoneNumber.text = contactInfoEntity.phoneNumber
        txtContactAge.text = contactInfoEntity.contactAge.toString()
        txtContactName.text = contactInfoEntity.contactName
        txtContactEmail.text = contactInfoEntity.contactEmail

        itemView.setOnClickListener {
            onClickListener(contactInfoEntity)
        }
    }
}