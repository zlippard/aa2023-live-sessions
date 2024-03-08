package com.zillow.android.flows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zillow.android.flows.ui.theme.AA2023Theme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
object StateFlows {
  val counterStateFlow = MutableStateFlow(0)

  init {
    GlobalScope.launch {
      while (true) {
        delay(1_000L)
        counterStateFlow.value += 1
      }
    }
  }
}

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      AA2023Theme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          var greeting by remember { mutableStateOf("") }
          val counter by StateFlows.counterStateFlow.collectAsState()

          Column {
            Text("Current Count: $counter")
            Spacer(modifier = Modifier.padding(16.dp))
            Text(greeting)
          }

          LaunchedEffect(Unit) {
            greetingFlow.collect { newGreeting ->
              greeting = newGreeting
            }
          }
        }
      }
    }
  }
}

val greetingFlow : Flow<String> = flow {
  emit("Hello there.")
  delay(1_000L)
  emit("Hello there..")
  delay(1_000L)
  emit("Hello there...")
  delay(3_500L)
  emit("How are you today?")
  delay(3_500L)
  emit("I'm doing great!")
  delay(1_000L)
  emit("I'm doing great! Thanks for asking!")
}
