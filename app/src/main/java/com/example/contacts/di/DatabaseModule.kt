package com.example.contacts.di

import android.content.Context
import androidx.room.Room
import com.example.contacts.data.local.ContactDataBase
import com.example.contacts.data.local.dao.ContactDao
import com.example.contacts.data.repository.LocalDataSourceImpl
import com.example.contacts.domain.repository.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun databaseProvider(@ApplicationContext context: Context): ContactDataBase =
        Room.databaseBuilder(
            context,
            ContactDataBase::class.java,
            ContactDataBase.DB_NAME
        ).build()

    @Provides
    @Singleton
    fun recipeDaoProvider(contactDataBase: ContactDataBase): ContactDao =
        contactDataBase.contactDao()

    @Provides
    @Singleton
    fun localDataSourceProvider(contactDao: ContactDao): LocalDataSource {
        return LocalDataSourceImpl(contactDao = contactDao)
    }

}