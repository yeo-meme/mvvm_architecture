package com.yeomeme.mvvmarchitecture

import androidx.lifecycle.LiveData
import androidx.room.*

/**

 * Created by yeomeme@gmail.com on 2021-04-02
 *
 */

@Dao
interface ContactDao {

    @Query("SELECT * FROM contact ORDER BY name ASC")
    fun getAll() : LiveData<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: Contact)

    @Delete
    fun delete(contact: Contact)
}