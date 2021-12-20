package net.codetreats.aoc2021.day18

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day18Test {
    private lateinit var classUnderTest : Day18

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day18()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("4435", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("4140", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("4802", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("3993", classUnderTest.run2())
    }
}
