package com.example.pw1_1.composables
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pw1_1.DisplayFor

@Composable
fun DisplayModeSelector(
    selected: DisplayFor,
    onSelectedChange: (DisplayFor) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Вибір рівня складності",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(8.dp))

        DisplayFor.entries.forEach { mode ->
            Button(
                onClick = { onSelectedChange(mode) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp),
                enabled = mode != selected
            ) {
                Text(
                    text = when (mode) {
                        DisplayFor.BASIC_LEVEL -> "Базовий рівень"
                        DisplayFor.MIDDLE_LEVEL -> "Середній рівень"
                        DisplayFor.ADVANCED_LEVEL -> "Просунутий рівень"
                    }
                )
            }
        }
    }
}