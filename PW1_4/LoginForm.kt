package com.example.pw1_4.forms

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginForm(onLogin: (String, String) -> String,onSwitchToRegister: () -> Unit) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Text(
        text = "Авторизація диспетчера КРМ",
        fontSize = 22.sp,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(bottom = 16.dp)
    )

    OutlinedTextField(
        value = login,
        onValueChange = { login = it },
        label = { Text("Табельний номер / Логін") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(8.dp))

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Пароль доступу") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    Button(
        onClick = { message = onLogin(login, password) },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Увійти до панелі керування")
    }

    Spacer(modifier = Modifier.height(8.dp))

    TextButton(onClick = onSwitchToRegister) {
        Text("Немає доступу? Зареєструвати оператора")
    }

    Spacer(modifier = Modifier.height(16.dp))

    if (message.isNotBlank()) {
        Text(
            text = message,
            color = if (message.contains("успішна")) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
        )
    }
}