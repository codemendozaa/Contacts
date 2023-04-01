package com.example.contacts.data.repository



import com.example.contacts.data.local.dao.ContactDao
import com.example.contacts.domain.model.Contact
import com.example.contacts.domain.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(private val contactDao: ContactDao) : LocalDataSource {

    override suspend fun insertAll(contact: List<Contact>) {
        contactDao.insertAll(contact)
    }

    override fun getAllContacts(): List<Contact> {
       return contactDao.getAllContacts()
    }

    override suspend fun getSelectedContact(contactId: Int): Contact? {
        return contactDao.getSelectedContacts(contactId = contactId)
    }

    override fun searchContacts(text: String): Flow<List<Contact>> {
        return  contactDao.searchContacts(text = text)
    }

}