package com.example.contacts.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.contacts.data.model.ContactResponseItem

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val username: String,
    val website:String
){
    fun toContactDTO(): ContactResponseItem =
        ContactResponseItem(
            id,
            name,
            email,
            username,
            phone,
            website,
            null,
            null
        )
}