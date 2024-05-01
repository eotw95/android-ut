package com.eotw95.androidutsample

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class InputCheckerTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    // assertThat()はDeprecatedなので使用しない
    @Test
    fun isValidTest() {
        val inputChecker = InputChecker()
        val actual = inputChecker.isValid("foo")
        assertTrue(actual)
        assertEquals(true, actual)
    }
}