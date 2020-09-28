package com.example.myapplication
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
    fun multiply_func_isCorrect() {
        val activityObj = MainActivity()
        val width = "2.0"
        val length = "5.0"
        val result = activityObj.multiply(length, width)

        assertEquals("10.0", result)
    }
}