package net.codetreats.aoc2021.day23

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day23Test {
    private lateinit var classUnderTest : Day23

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day23()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("11120", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("12521", classUnderTest.run1())
    }

    @Disabled
    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("49232", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("44169", classUnderTest.run2())
    }
}
