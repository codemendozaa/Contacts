package com.example.contacts.ui.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contacts.data.model.ContactResponseItem
import com.example.contacts.data.network.ApiService
import com.example.contacts.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    //private val contactRepository: ContactRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _searchedContacts = MutableStateFlow<List<ContactResponseItem>>(emptyList())
    val searchedRecipes = _searchedContacts.asStateFlow()


    var contactListResponse:List<ContactResponseItem> by mutableStateOf(listOf())
    private var errorMessage: String by mutableStateOf("")
    private var searchJob: Job? = null
    

    fun getContactList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val contactList = apiService.getContacts()
                contactListResponse = contactList
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

    fun searchContacts(text: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            viewModelScope.launch(dispatcher) {
               /* contactRepository.searchContacts(text = text)
                    .map { it.map { contact -> contact.toContactDTO()} }
                    .collect {
                        _searchedContacts.value = it
                    }*/
            }
        }
    }
}


