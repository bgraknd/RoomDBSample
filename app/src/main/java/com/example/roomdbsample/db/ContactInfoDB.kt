package com.example.roomdbsample.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdbsample.dao.ContactInfoDao
import com.example.roomdbsample.entity.ContactInfoEntity

/**
 * Created by Bugra on 20.04.2019 - 13:41
 */


@Database(entities = [ContactInfoEntity::class], version = 1)
abstract class ContactInfoDB : RoomDatabase() {

    abstract fun getContactInfoDao(): ContactInfoDao

    companion object {
        private var INSTANCE: ContactInfoDB? = null

        fun getInstance(context: Context): ContactInfoDB?{
            if (INSTANCE == null) {
                synchronized(ContactInfoDB::class) {
                    INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            ContactInfoDB::class.java, "contact_info_database"
                    )
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return INSTANCE
        }
    }
}