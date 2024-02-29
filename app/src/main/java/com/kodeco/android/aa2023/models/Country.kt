package com.kodeco.android.aa2023.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(val population: Long) : Parcelable
