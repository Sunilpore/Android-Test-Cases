package com.androidtesteg.simple_activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.androidtesteg.R
import com.androidtesteg.SecondActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondActivityTest{

    @get: Rule
    val activityRule = ActivityScenarioRule(SecondActivity::class.java)

    @Test
    fun test_isActivityInView(){
        onView(withId(R.id.lay_secondary))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_title_backbutton(){
        onView(withId(R.id.activity_secondary_title))
            .check(matches(isDisplayed()))

        onView(withId(R.id.button_back))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isTitleTextDisplayed(){

        onView(withId(R.id.activity_secondary_title))
            .check(matches(withText(R.string.text_secondaryactivity)))
    }
}