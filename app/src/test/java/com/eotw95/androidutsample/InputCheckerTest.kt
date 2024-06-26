package com.eotw95.androidutsample

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
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
    fun isValidTest_givenAlphabetic_returnTrue() {
        val actual = inputChecker.isValid("abc")
        assertEquals(true, actual)
    }
    @Test
    fun isValidTest_givenNumeric_returnTrue() {
        val actual = inputChecker.isValid("123")
        assertEquals(true, actual)
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
    @Test
    fun isValidTest_givenInvalidCharacter_returnFalse() {
        val invalidTexts = listOf(
            "abc@123",
            "@@@",
            "1$(abc)",
            "000_abc",
            "{abc}123"
        )
        invalidTexts.forEach {
            val actual = inputChecker.isValid(it)
            assertEquals(false, actual)
        }
    }
    @Ignore("write ignore reason")
    @Test
    fun temporarySkipTest() {}
}