package net.codetreats.aoc2021.day13

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day13Test {
    var classUnderTest = Day13()

    @BeforeEach
    fun setup() {

    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("638", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("17", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("CJCKBAPB", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("O", classUnderTest.run2())
    }
}
