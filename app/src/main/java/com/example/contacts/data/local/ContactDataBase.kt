package com.example.contacts.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.contacts.data.local.dao.ContactDao
import com.example.contacts.domain.model.Contact

@Database(entities = [Contact::class], version = 1, exportSchema = false)
@TypeConverters(DatabaseConverter::class)
abstract class ContactDataBase(): RoomDatabase() {
    abstract fun contactDao(): ContactDao
    companion object {
        const val DB_NAME = "contact.db"
    }
}