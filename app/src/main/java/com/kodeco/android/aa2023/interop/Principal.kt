package com.kodeco.android.aa2023.interop

data class Principal(
    val principalName: String,
    val principalAge: Int,
    val credentials: List<Credential>,
) : Person(principalName, principalAge)
