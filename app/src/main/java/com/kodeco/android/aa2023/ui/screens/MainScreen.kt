package com.kodeco.android.aa2023.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onButtonClick: (() -> Unit)? = null,
    onNavigate: ((route: String) -> Unit)? = null,
) {
    val backgroundPrimaryColor = MaterialTheme.colorScheme.background
    val backgroundSecondaryColor = MaterialTheme.colorScheme.secondary
    var backgroundColor by remember { mutableStateOf(backgroundPrimaryColor) }
    val state by viewModel.stateFlow.collectAsState()
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        when (val currentState = state) {
            is SchoolState.Loading -> Text("Loading")
            is SchoolState.Loaded -> {
                Column {
                    Text("Hello, Android, here's the school data: ${currentState.school}")
                    Button(onClick = { viewModel.sendIntent(Intent.DoSomething) })  {
                        Text("Do something")
                    }
                }

            }
            is SchoolState.Error -> Text("Error")
        }

        LaunchedEffect(Unit) {
            viewModel.actionFlow.collect { action ->
                when (action) {
                    is Action.Toast -> Toast.makeText(context, action.message, Toast.LENGTH_LONG).show()
                    is Action.Navigate -> onNavigate?.invoke(action.route)
                }
                // Perform action
            }
        }

        LaunchedEffect(Unit) {
            delay(2_500L)
            backgroundColor = backgroundSecondaryColor

            delay(2_500L)
            backgroundColor = backgroundPrimaryColor
        }
    }
}
