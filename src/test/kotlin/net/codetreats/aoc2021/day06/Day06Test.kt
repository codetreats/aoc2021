package net.codetreats.aoc2021.day06

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day06Test {
    private lateinit var classUnderTest : Day06

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day06()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("389726", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("5934", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("1743335992042", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("26984457539", classUnderTest.run2())
    }
}
