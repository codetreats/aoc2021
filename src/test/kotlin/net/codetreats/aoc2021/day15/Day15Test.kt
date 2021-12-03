package net.codetreats.aoc2021.day15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day15Test {
    var classUnderTest = Day15()

    @BeforeEach
    fun setup() {

    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("", classUnderTest.run2())
    }
}
