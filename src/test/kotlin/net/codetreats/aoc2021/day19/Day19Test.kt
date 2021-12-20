package net.codetreats.aoc2021.day19

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day19Test {
    private lateinit var classUnderTest : Day19

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day19()
    }

    @Disabled
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("451", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("79", classUnderTest.run1())
    }

    @Disabled
    fun testPart02() {
        classUnderTest.init(false)
        classUnderTest.run1()
        assertEquals("13184", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        classUnderTest.run1()
        assertEquals("3621", classUnderTest.run2())
    }
}
