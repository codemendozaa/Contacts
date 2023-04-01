package com.example.contacts.domain.repository


import com.example.contacts.domain.model.Contact
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun insertAll(contact: List<Contact>)
    fun getAllContacts(): List<Contact>
    suspend fun getSelectedContact(contactId: Int): Contact?
    fun searchContacts(text: String): Flow<List<Contact>>

}