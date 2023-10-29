package com.kodeco.android.aa2023.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
) {
    val backgroundPrimaryColor = MaterialTheme.colorScheme.background
    val backgroundSecondaryColor = MaterialTheme.colorScheme.secondary
    var backgroundColor by remember { mutableStateOf(backgroundPrimaryColor) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        Text("Hello, Android, here's the school data: ${viewModel.getSchool()}")

        LaunchedEffect(Unit) {
            delay(2_500L)
            backgroundColor = backgroundSecondaryColor

            delay(2_500L)
            backgroundColor = backgroundPrimaryColor
        }
    }
}
