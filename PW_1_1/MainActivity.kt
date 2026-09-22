package com.example.pw1_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pw1_1.composables.*
import com.example.pw1_1.ui.theme.PW1_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PW1_1Theme {
                var displayFor by remember { mutableStateOf(DisplayFor.BASIC_LEVEL) }

                Surface(modifier = Modifier.fillMaxSize()) {
                    Column {
                        DisplayModeSelector(
                            selected = displayFor,
                            onSelectedChange = { displayFor = it }
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        when (displayFor) {
                            DisplayFor.BASIC_LEVEL -> ReactivePowerAppLevel1()
                            DisplayFor.MIDDLE_LEVEL -> ReactivePowerAppLevel2()
                            DisplayFor.ADVANCED_LEVEL -> ReactivePowerAppLevel3()
                        }
                    }
                }
            }
        }
    }
}