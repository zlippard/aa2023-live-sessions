package com.kodeco.android.aa2023.interop

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val title: String,
    val author: String,
    val pageCount: Int,
) : Parcelable
