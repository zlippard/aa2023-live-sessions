package com.kodeco.android.aa2023.interop

data class Principal(
    val name: String,
    val age: Int,
    val credentials: List<Credential>,
) : Person(name, age)
