package com.zillow.android.generics

import kotlin.reflect.KClass

object Generics {
  fun getUnknownList(): List<*> {
    return listOf("a", "b", "c")
  }

  fun <T : Any> getList(type: KClass<T>): List<T>? {
    return when (type) {
      String::class -> listOf("a", "b", "c") as List<T>
      Int::class -> listOf(1, 2, 3) as List<T>
      Boolean::class -> listOf(true, true, false) as List<T>
      else -> null
    }
  }


  inline fun <reified T : Any> reifiedGetList(): List<T>? {
    return when (T::class) {
      String::class -> listOf("a", "b", "c") as List<T>
      Int::class -> listOf(1, 2, 3) as List<T>
      Boolean::class -> listOf(true, true, false) as List<T>
      else -> null
    }
  }
}

fun main () {
  val unknownList = Generics.getUnknownList()

  // We can't check the underlying type here!
//  if (unknownList is List<String>) {
//    println("list elements are the expected type!")
//  } else {
//    println("list elements are NOT expected type!")
//  }

  val list = Generics.getList(String::class)

  if (list is List<String>) {
    println("list elements are the expected type!")
  } else {
    println("list elements are NOT expected type!")
  }

  val reifiedList = Generics.reifiedGetList<Boolean>()

  if (reifiedList is List<Boolean>) {
    println("reifiedList elements are expected type!")
  } else {
    println("reifiedList elements are NOT expected type!")
  }
}
