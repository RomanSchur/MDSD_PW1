package com.example.pw1_1.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ReactivePowerAppLevel1() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8EAF6))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Компенсація реактивної потужності",
            fontSize = 20.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { /* Дія для базового рівня */ }) {
            Text("Оновити параметри мережі")
        }
    }
}