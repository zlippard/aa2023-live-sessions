package com.kodeco.android.aa2023.robots

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule

class NextRobot<A : ComponentActivity>(composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>) {
    fun doSomething() {}
}
