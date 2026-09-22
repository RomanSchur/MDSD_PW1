package com.example.pw1_3.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pw1_3.R

@Composable
fun AdvancedEnergyApp() {
    var reactivePower by remember { mutableStateOf(45) }
    var selectedMode by remember { mutableStateOf("Мінімальний") }
    var statusComment by remember { mutableStateOf("1 ступінь БСК увімкнено (норма)") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Компенсація реактивної потужності",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ModeButton(
                label = "Мінімум",
                modifier = Modifier.weight(1f),
                onClick = {
                    selectedMode = "Мінімальний"
                    reactivePower = 35
                    statusComment = "1 ступінь БСК (cos φ = 0.98)"
                }
            )
            ModeButton(
                label = "Номінал",
                modifier = Modifier.weight(1f),
                onClick = {
                    selectedMode = "Номінальний"
                    reactivePower = 120
                    statusComment = "3 ступені БСК (cos φ = 0.95)"
                }
            )
            ModeButton(
                label = "Пік",
                modifier = Modifier.weight(1f),
                onClick = {
                    selectedMode = "Піковий"
                    reactivePower = 260
                    statusComment = "Повна потужність БСК (cos φ = 0.92)"
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.capacitor_bank),
            contentDescription = "Батарея статичних конденсаторів",
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        InfoCard(
            mode = selectedMode,
            power = reactivePower,
            comment = statusComment
        )
    }
}
@Composable
fun ModeButton(
    label: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = label, fontSize = 13.sp)
    }
}
@Composable
fun InfoCard(
    mode: String,
    power: Int,
    comment: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Режим навантаження: $mode",
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Потужність Q: $power кВАР",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Стан системи: $comment",
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}