package net.codetreats.aoc2021.day25

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day25Test {
    private lateinit var classUnderTest : Day25

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day25()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("337", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("58", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("", classUnderTest.run2())
    }
}
