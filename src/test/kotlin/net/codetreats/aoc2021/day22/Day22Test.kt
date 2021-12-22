package net.codetreats.aoc2021.day22

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day22Test {
    private lateinit var classUnderTest : Day22

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day22()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("581108", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("474140", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("1325473814582641", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("2758514936282235", classUnderTest.run2())
    }
}
