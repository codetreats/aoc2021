package net.codetreats.aoc2021.day01

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day01Test {
    var classUnderTest = Day01()

    @BeforeEach
    fun setup() {

    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("1791", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("7", classUnderTest.run1()) }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("1822", classUnderTest.run2())
    }
}