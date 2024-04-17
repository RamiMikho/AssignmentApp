package com.rami.assignmentapplication

import org.junit.Assert.*
import android.content.pm.ActivityInfo
import android.widget.Button

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    private var myAddScore = 0
    private var myReduceScore = 0
    private var myReset = 0
    private var myScoreTextField = 0

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        // Please set your id names here.
        myAddScore = R.id.AddScore
        myReduceScore = R.id.ReduceScore
        myReset = R.id.Reset
        myScoreTextField = R.id.Score
    }

}