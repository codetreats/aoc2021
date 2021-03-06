package net.codetreats.aoc2021.day05

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day05Test {
    private lateinit var classUnderTest : Day05

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day05()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("7380", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("5", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("21373", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("12", classUnderTest.run2())
    }
}
