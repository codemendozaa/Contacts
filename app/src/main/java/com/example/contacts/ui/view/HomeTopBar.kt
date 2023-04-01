package com.example.contacts.ui.view

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.contacts.R
import com.example.contacts.ui.theme.topAppBarBackgroundColor
import com.example.contacts.ui.theme.topAppBarContentColor

@Composable
fun HomeTopBar(){
    var showMenu by remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.title_app),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_filter),
                    contentDescription = stringResource(id = R.string.search_icon)
                )
            }

        }
    )
}