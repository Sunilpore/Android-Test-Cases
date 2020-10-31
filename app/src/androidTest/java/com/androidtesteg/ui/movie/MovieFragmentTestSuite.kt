package com.androidtesteg.ui.movie

import org.junit.runner.RunWith
import org.junit.runners.Suite


/**
 * Run all test cases with single entry point
 */
@RunWith(Suite::class)
@Suite.SuiteClasses(
    MovieDetailFragmentTest::class,
    DirectorsFragmentTest::class,
    StarActorsFragmentTest::class,
    MovieNavigationTest::class
)
class MovieFragmentTestSuite