package com.example.pw1_4.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pw1_4.forms.LoginForm
import com.example.pw1_4.forms.RegistrationForm

@Composable
fun LoginScreen() {
    var isRegisterMode by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isRegisterMode) {
            RegistrationForm(
                onRegister = { name, email, password, confirmPassword ->
                    isLoading = true
                    isLoading = false
                    when {
                        name.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank() ->
                            "Будь ласка, заповніть усі поля"
                        password != confirmPassword ->
                            "Паролі не співпадають!"
                        password.length < 6 ->
                            "Пароль має містити щонайменше 6 знаків"
                        else ->
                            "Реєстрація успішна! Профіль додано до системи."
                    }
                },
                onSwitchToLogin = { isRegisterMode = false }
            )
        } else {
            LoginForm(
                onLogin = { login, password ->
                    isLoading = true
                    isLoading = false
                    when {
                        login.isBlank() || password.isBlank() ->
                            "Заповніть табельний номер та пароль"
                        else ->
                            "Авторизація успішна! Доступ до мережі надано."
                    }
                },
                onSwitchToRegister = { isRegisterMode = true }
            )
        }
        if (isLoading) {
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator()
        }
    }
}