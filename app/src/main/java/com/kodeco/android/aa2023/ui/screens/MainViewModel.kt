package com.kodeco.android.aa2023.ui.screens

import androidx.lifecycle.ViewModel
import com.kodeco.android.aa2023.repositories.SchoolRepository
import com.kodeco.android.aa2023.interop.School
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: SchoolRepository,
): ViewModel() {
    fun getSchool(): School = repository.getSchool()
}
