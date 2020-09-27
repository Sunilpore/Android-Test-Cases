package com.androidtesteg.simple_activity

import com.androidtesteg.MainActivity
import com.androidtesteg.activity_navigation.MainActivityTest
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    SecondActivityTest::class
)
class ActivityTestSuite