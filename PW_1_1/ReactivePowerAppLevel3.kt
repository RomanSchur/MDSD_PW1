package com.example.pw1_1.composables
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun ReactivePowerAppLevel3() {
    var reactivePower by remember { mutableStateOf(85) }
    var cosPhi by remember { mutableStateOf(0.92) }

    val animatedPower by animateIntAsState(
        targetValue = reactivePower,
        label = "PowerAnimation"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Компенсація реактивної потужності",
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Потужність Q: $animatedPower кВАР",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Коефіцієнт cos φ: $cosPhi",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            reactivePower = Random.nextInt(30, 250)
            cosPhi = (Random.nextInt(85, 99) / 100.0)
        }) {
            Text("Оновити та скомпенсувати")
        }
    }
}