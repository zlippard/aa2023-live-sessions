package com.kodeco.android.aa2023.robots

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule


// Robots provide the "How" to test
class SampleRobot<A : ComponentActivity>(
    private val composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>
) {
    private val helloText = composeTestRule.onNodeWithTag("hello_text")
    private val descriptionText = composeTestRule.onNodeWithTag("description_text")
    private val button = composeTestRule.onNodeWithTag("button")

    fun verifyUi() {
        helloText
            .assertIsDisplayed()
            .assertTextEquals("Hello!")
        descriptionText.assertIsDisplayed()
        button.assertIsDisplayed()
    }

    fun clickButton() {
        button.performClick()
    }

    fun verifyUiAfterButtonClick() {
        helloText.assertTextEquals("Hello! Button clicked!")
    }

    infix fun navigateToNext(block: NextRobot<A>.() -> Unit): NextRobot<A> {
        return NextRobot(composeTestRule).apply(block)
    }

    companion object {
        fun <A : ComponentActivity> create(
            composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>,
            block: SampleRobot<A>.() -> Unit,
        ): SampleRobot<A> {
            val sampleRobot = SampleRobot(composeTestRule)
            return sampleRobot.apply(block)
        }
    }
}
