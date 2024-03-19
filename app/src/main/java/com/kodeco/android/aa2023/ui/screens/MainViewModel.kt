package com.kodeco.android.aa2023.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kodeco.android.aa2023.repositories.SchoolRepository
import com.kodeco.android.aa2023.interop.School
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface SchoolState {
    data object Loading : SchoolState
    data class Loaded(val school: School) : SchoolState
    data object Error : SchoolState
}

sealed interface Action {
    data class Toast(val message: String) : Action
    data class Navigate(val route: String) : Action
}

sealed interface Intent {
    data object DoSomething : Intent
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: SchoolRepository,
): ViewModel() {

    private val _stateFlow = MutableStateFlow<SchoolState>(SchoolState.Loading)
    val stateFlow: StateFlow<SchoolState> = _stateFlow.asStateFlow()

    private val _actionFlow = MutableSharedFlow<Action>()
    val actionFlow: SharedFlow<Action> = _actionFlow.asSharedFlow()

    fun sendIntent(intent: Intent) {
        when (intent) {
            is Intent.DoSomething -> doSomething()
        }
    }

    private fun doSomething() {
        // Metrics / Analytics calls
        viewModelScope.launch {
            _actionFlow.emit(Action.Toast("Something happened"))
            _actionFlow.emit(Action.Navigate("/details"))
        }
    }

//    fun getSchool(): School = repository.getSchool()
}
