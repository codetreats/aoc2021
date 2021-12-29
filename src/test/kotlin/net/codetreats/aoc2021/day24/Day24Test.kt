package net.codetreats.aoc2021.day24

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day24Test {
    private lateinit var classUnderTest : Day24

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day24()
    }

    @Test
    fun testPart01() {
        classUnderTest.init(false)
        assertEquals("99919692496939", classUnderTest.run1())
    }

    @Test
    fun testPart02() {
        classUnderTest.init(false)
        assertEquals("81914111161714", classUnderTest.run2())
    }
}
