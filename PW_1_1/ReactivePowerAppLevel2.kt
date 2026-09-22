package com.example.pw1_1.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun ReactivePowerAppLevel2() {
    var reactivePower by remember { mutableStateOf(120) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEDE7F6))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Моніторинг мережі",
            fontSize = 22.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Реактивна потужність: $reactivePower кВАР",
            fontSize = 18.sp,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            reactivePower = Random.nextInt(20, 300)
        }) {
            Text("Виміряти навантаження")
        }
    }
}