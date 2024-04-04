package com.kodeco.android.aa2023

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.kodeco.android.aa2023.ui.components.SampleComposable
import com.kodeco.android.aa2023.ui.theme.AA2023Theme
import org.junit.Rule
import org.junit.Test

class SampleComposableTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun sampleComposableTest() {
        // Start the app
        composeTestRule.setContent {
            AA2023Theme {
                SampleComposable()
            }
        }

        composeTestRule.onNodeWithTag("hello_text")
            .assertIsDisplayed()
            .assertTextEquals("Hello!")
        composeTestRule.onNodeWithTag("description_text")
            .assertIsDisplayed()

        composeTestRule.onNodeWithTag("button")
            .assertIsDisplayed()
            .performClick()

        composeTestRule.onNodeWithTag("hello_text")
            .assertTextEquals("Hello! Button clicked!")
    }

}
