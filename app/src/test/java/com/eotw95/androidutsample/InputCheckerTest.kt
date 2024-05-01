package com.eotw95.androidutsample

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class InputCheckerTest {
    private lateinit var inputChecker: InputChecker

    @Before
    fun setUp() {
        inputChecker = InputChecker()
    }

    @After
    fun tearDown() {
    }

    // assertThat()はDeprecatedなので使用しない
    @Test
    fun isValidTest() {
        val actual = inputChecker.isValid("foo")
        assertTrue(actual)
        assertEquals(true, actual)
    }
    @Test
    fun isValidTest_givenLessThan3_returnFalse() {
        val actual = inputChecker.isValid("ab")
        assertEquals(false, actual)
    }
    @Test
    fun isValidTest_givenAlphaNumeric_returnTrue() {
        val actual = inputChecker.isValid("abc123")
        assertEquals(true, actual)
    }
    @Test(expected = IllegalArgumentException::class)
    fun isValidTest_givenNull_throwException() {
        inputChecker.isValid(null)
    }
}