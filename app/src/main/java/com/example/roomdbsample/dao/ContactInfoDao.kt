package com.example.roomdbsample.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdbsample.entity.ContactInfoEntity

/**
 * Created by Bugra on 20.04.2019 - 13:19
 */
@Dao
interface ContactInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewItem(contactInfoEntity: ContactInfoEntity)

    @Delete
    fun removeItem(contactInfoEntity: ContactInfoEntity)

    @Update
    fun updateItem(contactInfoEntity: ContactInfoEntity)

    @Query("SELECT * FROM contact_table WHERE id LIKE :id")
    fun findSingleItem(id: Int): ContactInfoEntity

    @Query("SELECT * FROM contact_table")
    fun getAllList(): LiveData<List<ContactInfoEntity>>

    @Query("DELETE FROM contact_table")
    fun deleteAllList()


}