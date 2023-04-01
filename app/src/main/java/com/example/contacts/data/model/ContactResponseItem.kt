package com.example.contacts.data.model

data class ContactResponseItem(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val username: String,
    val website: String,
    val address: Address?,
    val company: Company?,
)