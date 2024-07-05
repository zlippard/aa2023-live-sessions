package com.kodeco.android.aa2023.tests

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.kodeco.android.aa2023.MainActivity
import com.kodeco.android.aa2023.robots.SampleRobot
import org.junit.Rule
import org.junit.Test

class SampleComposableUiTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    // The test case knows "what" to test
    @Test
    fun sampleComposableTest() {
        SampleRobot.create(composeTestRule) {
            verifyUi()
            clickButton()
            verifyUiAfterButtonClick()
        } navigateToNext {
            doSomething()
        }
    }
}
