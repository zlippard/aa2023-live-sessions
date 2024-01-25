package com.kodeco.android.aa2023

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.kodeco.android.aa2023.databinding.CustomLayoutBinding
import com.kodeco.android.aa2023.databinding.MainActivityBinding
import com.kodeco.android.aa2023.ui.screens.MainScreen
import com.kodeco.android.aa2023.ui.theme.AA2023Theme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AA2023Theme {
                MaiflkjlkjnScreen()

            }
        }

//        binding = MainActivityBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        AlertDialog.Builder(this)
//            .show()
//
//        binding.textView.text = "Hello there, from code!!"
//
//        binding.composeView.setContent {
//            AA2023Theme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Column {
//                        Greeting(name = "Android")
//
//                        AndroidViewBinding(CustomLayoutBinding::inflate) {
//                            customTextView.text = "Here's the custom text view!"
//                        }
//                    }
//                }
//            }
//        }
    }
}
