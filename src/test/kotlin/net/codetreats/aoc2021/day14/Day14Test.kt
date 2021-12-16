package net.codetreats.aoc2021.day14

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day14Test {
    private lateinit var classUnderTest : Day14

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day14()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("2891", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("1588", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("4607749009683", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("2188189693529", classUnderTest.run2())
    }
}
