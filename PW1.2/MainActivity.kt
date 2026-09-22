package com.example.pw1_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.pw1_2.composables.EnergyApp
import com.example.pw1_2.ui.theme.PW1_2Theme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PW1_2Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    EnergyApp()
                }
            }
        }
    }
}
