package net.codetreats.aoc2021.day11

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day11Test {
    lateinit var classUnderTest : Day11

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day11()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("1625", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("1656", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("244", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("195", classUnderTest.run2())
    }
}
