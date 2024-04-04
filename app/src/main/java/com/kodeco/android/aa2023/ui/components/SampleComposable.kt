package com.kodeco.android.aa2023.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun SampleComposable() {
    var helloText by remember { mutableStateOf("Hello!") }
    Column {
        Text(helloText, modifier = Modifier.testTag("hello_text"))
        Text("This is a sample app.", modifier = Modifier.testTag("description_text"))
        Button(
            onClick = { helloText = "Hello! Button clicked!" },
            modifier = Modifier.testTag("button"),
        ) {
            Text("Click me to change the text!")
        }
    }
}
