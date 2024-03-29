// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.hilt) apply false
  alias(libs.plugins.org.jetbrains.kotlin.jvm) apply false
}

buildscript {
    dependencies {
        classpath(libs.navigation.safeargs)
    }
}
