package com.example.roomdbsample.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Bugra on 20.04.2019 - 13:09
 */

@Entity(tableName = "contact_table")
data class ContactInfoEntity(

        @PrimaryKey(autoGenerate = true) val id: Int = 0,

        @ColumnInfo(name = "phoneNumber") val phoneNumber: String,

        @ColumnInfo(name = "contactName") val contactName: String,

        @ColumnInfo(name = "contactAge") val contactAge: Int,

        @ColumnInfo(name = "contactEmail") val contactEmail: String

) {
}

