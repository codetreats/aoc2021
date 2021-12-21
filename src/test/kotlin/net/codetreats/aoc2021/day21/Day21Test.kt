package net.codetreats.aoc2021.day21

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day21Test {
    private lateinit var classUnderTest : Day21

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day21()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("864900", classUnderTest.run1())
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.init(true)
        assertEquals("739785", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("575111835924670", classUnderTest.run2())
    }

    @Test
    fun testPart02_dummyData() {
        classUnderTest.init(true)
        assertEquals("444356092776315", classUnderTest.run2())
    }
}
