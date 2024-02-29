package com.kodeco.android.aa2023

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.kodeco.android.aa2023.databinding.CustomLayoutBinding
import com.kodeco.android.aa2023.databinding.MainActivityBinding
import com.kodeco.android.aa2023.models.Country
import com.kodeco.android.aa2023.network.CountryService
import com.kodeco.android.aa2023.ui.theme.AA2023Theme
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlinx.parcelize.Parcelize
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : ComponentActivity() {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://restcountries.com/v3.1/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private val service: CountryService = retrofit.create(CountryService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AA2023Theme {
                var uiState: CountryUIState by rememberSaveable { mutableStateOf(CountryUIState.Loading) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val stateStr = when (val currentUiState = uiState) {
                        is CountryUIState.Loaded -> "Loaded with ${currentUiState.countries.size} countries"
                        is CountryUIState.Loading -> "Loading..."
                        is CountryUIState.Error -> "Error occurred: ${currentUiState.exception}"
                    }

                    Greeting("Android\n\n$stateStr")

                    LaunchedEffect(Unit) {
                        delay(5_000L)
                        uiState = try {
                            CountryUIState.Loaded(service.getAllCountries())
                        } catch (exception: Exception) {
                            CountryUIState.Error(exception)
                        }
                    }
                }
            }
        }
    }
}

@Parcelize
data class CountryResponse(val countries: List<Country>?, val error: Throwable?) : Parcelable

@Parcelize
sealed class CountryUIState : Parcelable {
    data class Loaded(val countries: List<Country>) : CountryUIState()

    object Loading: CountryUIState()

    data class Error(val exception: Throwable) : CountryUIState()
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AA2023Theme {
        Greeting("Android")
    }
}
