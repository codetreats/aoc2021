package net.codetreats.aoc2021.day08

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day08Test {
    private lateinit var classUnderTest : Day08

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day08()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("412", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("26", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("978171", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("61229", classUnderTest.run2())
    }
}
