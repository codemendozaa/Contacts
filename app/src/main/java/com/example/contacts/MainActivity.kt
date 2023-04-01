package com.example.contacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.contacts.data.model.Address
import com.example.contacts.data.model.Company
import com.example.contacts.data.model.ContactResponseItem
import com.example.contacts.data.model.Geo
import com.example.contacts.ui.theme.ContactsTheme
import com.example.contacts.ui.view.ContactItem
import com.example.contacts.ui.view.SearchWidget
import com.example.contacts.ui.viewModel.ContactViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val contactViewModel by viewModels<ContactViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

                    ContactList(contactList = contactViewModel.contactListResponse)
                    contactViewModel.getContactList()
                }
            }
        }
    }
}


@Composable
fun ContactList(contactList: List<ContactResponseItem>,contactViewModel: ContactViewModel = hiltViewModel()) {
    var text by remember { mutableStateOf("") }
    Box(contentAlignment = Alignment.BottomStart) {
        Column(modifier = Modifier.fillMaxSize()) {
            SearchWidget(text = text, onTextChange = { newText ->
                text = newText
                contactViewModel.searchContacts(text = newText)
            })
            LazyColumn {
                itemsIndexed(items = contactList) { index, item ->
                    ContactItem(contact = item)
                }
            }
}

}






@Composable
fun DefaultPreview() {
    ContactsTheme {
        val contact = ContactResponseItem(
            id = 0,
            name = "Erix",
            email = "erixtest@gmail.com",
            phone = "311111111",
            username = "codemendozaa",
            website = "www.code.test.com",
            address = Address("medellin", Geo("1233","321"),"test","test","test"),
            company = Company("test","test","test")

        )

        ContactItem(contact = contact )
    }
}
}