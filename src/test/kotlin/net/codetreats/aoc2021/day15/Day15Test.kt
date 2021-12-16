package net.codetreats.aoc2021.day15

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day15Test {
    val classUnderTest = Day15()

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("698", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("40", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("3022", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("315", classUnderTest.run2())
    }
}
