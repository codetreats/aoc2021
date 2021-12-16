package net.codetreats.aoc2021.day10

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day10Test {
    private lateinit var classUnderTest : Day10

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day10()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("413733", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("26397", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("3354640192", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("288957", classUnderTest.run2())
    }
}
