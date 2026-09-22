package com.example.pw1_2.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pw1_2.data.Calculator

@Composable
fun EnergyApp() {
    var activePower by remember { mutableStateOf("") }
    var cosPhi1 by remember { mutableStateOf("") }
    var cosPhi2 by remember { mutableStateOf("") }
    var resultQc by remember { mutableStateOf<Double?>(null) }

    val calculator = remember { Calculator() }

    val backgroundColor = Color.Black
    val textColor = Color.White
    val buttonColor = Color.White
    val buttonTextColor = Color.Black
    val fieldBorderColor = Color(0xFF666666)
    val focusedBorderColor = Color.White

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .statusBarsPadding()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text(
            text = "Розрахунок компенсації реактивної потужності",
            color = textColor,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        OutlinedTextField(
            value = activePower,
            onValueChange = { activePower = it },
            label = { Text("Активна потужність P (кВт)", color = Color.LightGray) },
            placeholder = { Text("Наприклад: 250", color = Color.Gray) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = textColor,
                unfocusedTextColor = textColor,
                focusedBorderColor = focusedBorderColor,
                unfocusedBorderColor = fieldBorderColor,
                cursorColor = textColor
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = cosPhi1,
            onValueChange = { cosPhi1 = it },
            label = { Text("Початковий коефіцієнт cos φ1", color = Color.LightGray) },
            placeholder = { Text("Наприклад: 0.70", color = Color.Gray) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = textColor,
                unfocusedTextColor = textColor,
                focusedBorderColor = focusedBorderColor,
                unfocusedBorderColor = fieldBorderColor,
                cursorColor = textColor
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = cosPhi2,
            onValueChange = { cosPhi2 = it },
            label = { Text("Бажаний коефіцієнт cos φ2", color = Color.LightGray) },
            placeholder = { Text("Наприклад: 0.95", color = Color.Gray) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = textColor,
                unfocusedTextColor = textColor,
                focusedBorderColor = focusedBorderColor,
                unfocusedBorderColor = fieldBorderColor,
                cursorColor = textColor
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        Button(
            onClick = {
                resultQc = calculator.calculatePowerAdvanced(
                    activePowerStr = activePower,
                    cosPhi1Str = cosPhi1,
                    cosPhi2Str = cosPhi2
                )
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonColor,
                contentColor = buttonTextColor
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Розрахувати потужність батареї", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        resultQc?.let { qc ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF1E1E1E)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Необхідна потужність компенсації:",
                        color = Color.LightGray,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "$qc кВАР",
                        color = Color.White,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}