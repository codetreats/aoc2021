package net.codetreats.aoc2021.day04

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day04Test {
    private lateinit var classUnderTest : Day04

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day04()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("16674", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("4512", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("7075", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("1924", classUnderTest.run2())
    }
}
