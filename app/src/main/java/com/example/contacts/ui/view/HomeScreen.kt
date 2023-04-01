package com.example.contacts.ui.view


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.contacts.R
import com.example.contacts.data.model.ContactResponseItem

@Composable
fun ContactItem(contact: ContactResponseItem) {
    Box(Modifier.padding(8.dp, 4.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
        ) {
            Surface() {
                Column(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.8f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Text(
                                text = contact.name,
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.padding(6.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_email),
                                    contentDescription = "Email Icon",
                                    modifier = Modifier
                                        .size(16.dp)
                                )
                                Text(
                                    text = contact.email,
                                    style = MaterialTheme.typography.caption,
                                    modifier = Modifier
                                        .background(Color.LightGray)
                                        .padding(start = 4.dp)
                                )
                            }
                            Spacer(modifier = Modifier.padding(3.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_phone),
                                    contentDescription = "Phone Icon",
                                    modifier = Modifier
                                        .size(16.dp)
                                )
                                Text(
                                    text = contact.phone,
                                    style = MaterialTheme.typography.body1,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier
                                        .padding(start = 4.dp)
                                )
                            }
                        }
                    }

                    Text(
                        text = "Mostrar publicaciones",
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier
                            .padding(top = 8.dp, end = 8.dp)
                            .align(Alignment.End)
                            .clickable { /* Aquí va la acción al hacer click */ }
                    )
                }
            }
        }
    }
        }
