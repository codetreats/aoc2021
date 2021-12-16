package net.codetreats.aoc2021.day07

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day07Test {
    private lateinit var classUnderTest : Day07

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day07()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("347011", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("37", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("98363777", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("168", classUnderTest.run2())
    }
}
