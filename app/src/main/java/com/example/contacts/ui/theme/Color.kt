package com.example.contacts.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Colors.topAppBarContentColor
    @Composable
    get() = if(isLight) Color.White else LightGray

val Colors.topAppBarBackgroundColor
    @Composable
    get() = if(isLight) Purple500 else Color.Black

val Colors.textColor
    @Composable
    get() = if(isLight) Color.Black else LightGray

val Colors.cardBackgroundColor
    @Composable
    get() = if(isLight) Color.White else Color.Black.copy(alpha = 0.2f)