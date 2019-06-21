package com.example.roomdbsample.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbsample.entity.ContactInfoEntity

/**
 * Created by Bugra on 21.04.2019 - 13:05
 */


class ContactListAdapter(

        private var contactInfoList: List<ContactInfoEntity>?=null,
        private val onClickListener: (contactInfoEntity: ContactInfoEntity) -> Unit)
    : RecyclerView.Adapter<ContactListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder =
            ContactListViewHolder(parent)

    override fun getItemCount(): Int {
        contactInfoList?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: ContactListViewHolder, position: Int) {
        contactInfoList?.let {
            holder.bind(it.get(position), onClickListener)
        }}

        fun setNewItem(contactInfoList: List<ContactInfoEntity>) {

            this.contactInfoList = contactInfoList
            notifyDataSetChanged()
        }
    }