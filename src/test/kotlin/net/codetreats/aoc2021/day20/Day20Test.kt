package net.codetreats.aoc2021.day20

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day20Test {
    private lateinit var classUnderTest : Day20

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day20()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("5486", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("35", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("20210", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("3351", classUnderTest.run2())
    }
}
