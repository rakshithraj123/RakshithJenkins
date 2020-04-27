package com.devteam.jetpackusers

import com.devteam.jetpackusers.utils.EmailValidator
import org.junit.Test

import org.junit.Assert.*

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

    @Test
    fun multiplication_isCorrect() {
        assertEquals(10, 2 * 5)
    }

    @Test
    fun emailValidator_isCorrectEmailId() {
        assertEquals(true, EmailValidator.isValidEmail("test@gmail.com"))
    }

}
