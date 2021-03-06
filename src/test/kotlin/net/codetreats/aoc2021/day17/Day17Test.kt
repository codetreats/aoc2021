package net.codetreats.aoc2021.day17

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day17Test {
    private lateinit var classUnderTest : Day17

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day17()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("17766", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("45", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("1733", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("112", classUnderTest.run2())
    }
}
