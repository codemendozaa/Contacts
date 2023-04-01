package com.example.contacts.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contacts.domain.model.Contact
import kotlinx.coroutines.flow.Flow
@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(contacts: List<Contact>)

    @Query("SELECT * FROM contact")
    fun getAllContacts(): List<Contact>

    @Query("DELETE FROM contact")
    suspend fun clear(): Unit

    @Query("SELECT * FROM contact WHERE id =:contactId")
    fun getSelectedContacts(contactId: Int): Contact?

    @Query("SELECT * FROM contact WHERE name LIKE :text")
    fun searchContacts(text: String): Flow<List<Contact>>

}