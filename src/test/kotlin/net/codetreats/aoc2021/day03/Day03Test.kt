package net.codetreats.aoc2021.day03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day03Test {
    var classUnderTest = Day03()

    @BeforeEach
    fun setup() {

    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("4191876", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("198", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("3414905", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("230", classUnderTest.run2())
    }

    @Test
    fun invertString_ShouldReturnCorrectValues() {
        assertEquals("", "".invert())
        assertEquals("1", "0".invert())
        assertEquals("101", "010".invert())
        assertEquals("111", "000".invert())
    }
}
