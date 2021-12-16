package net.codetreats.aoc2021.day15

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day15Test {


    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
    }

    @Test
    fun testPart01() {
        val classUnderTest = object : Day15() {
            override fun useDummy() = false
        }
        classUnderTest.init()
        assertEquals("698", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        val classUnderTest = object : Day15() {
            override fun useDummy() = true
        }
        classUnderTest.init()
        assertEquals("40", classUnderTest.run1())
    }

    @Ignore
    fun testPart02() {
        val classUnderTest = object : Day15() {
            override fun useDummy() = false
        }
        classUnderTest.init()
        assertEquals("3022", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        val classUnderTest = object : Day15() {
            override fun useDummy() = true
        }
        classUnderTest.init()
        assertEquals("315", classUnderTest.run2())
    }
}
