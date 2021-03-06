package net.codetreats.aoc2021.day09

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day09Test {
    private lateinit var classUnderTest : Day09

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day09()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("514", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("15", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("1103130", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("1134", classUnderTest.run2())
    }
}
