package net.codetreats.aoc2021.day16

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day16Test {
    private lateinit var classUnderTest : Day16

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day16()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("1002", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("31", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("1673210814091", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("54", classUnderTest.run2())
    }
}
