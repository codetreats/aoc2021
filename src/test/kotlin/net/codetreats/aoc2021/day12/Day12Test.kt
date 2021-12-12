package net.codetreats.aoc2021.day12

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day12Test {
    var classUnderTest = Day12()

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("3802", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("10", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("99448", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("36", classUnderTest.run2())
    }
}
