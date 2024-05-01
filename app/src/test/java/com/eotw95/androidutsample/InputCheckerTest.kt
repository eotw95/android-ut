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
    @Test
    fun isValidTest_givenLessThan3_returnFalse() {
        val inputChecker = InputChecker()
        val actual = inputChecker.isValid("ab")
        assertEquals(false, actual)
    }
    @Test
    fun isValidTest_givenAlphaNumeric_returnTrue() {
        val inputChecker = InputChecker()
        val actual = inputChecker.isValid("abc123")
        assertEquals(true, actual)
    }
}