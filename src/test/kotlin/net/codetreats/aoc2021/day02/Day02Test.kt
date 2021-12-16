package net.codetreats.aoc2021.day02

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day02Test {
    private lateinit var classUnderTest : Day02

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day02()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("1840243", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("150", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("1727785422", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("900", classUnderTest.run2())
    }

}
