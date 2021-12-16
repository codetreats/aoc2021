package net.codetreats.aoc2021.day04

import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BoardTest {
    private lateinit var classUnderTest: Board

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Board(5)
        for (i in 1..25) {
            classUnderTest.addField(i)
        }
    }

    @Test
    fun firstRowChosen_ShouldReturnTrue() {
        classUnderTest.choose(1)
        classUnderTest.choose(2)
        classUnderTest.choose(3)
        classUnderTest.choose(4)
        classUnderTest.choose(5)
        assertTrue(classUnderTest.checkWin())
    }

    @Test
    fun thirdRowChosen_ShouldReturnTrue() {
        classUnderTest.choose(11)
        classUnderTest.choose(12)
        classUnderTest.choose(13)
        classUnderTest.choose(14)
        classUnderTest.choose(15)
        assertTrue(classUnderTest.checkWin())
    }

    @Test
    fun firstColChosen_ShouldReturnTrue() {
        classUnderTest.choose(1)
        classUnderTest.choose(6)
        classUnderTest.choose(11)
        classUnderTest.choose(16)
        classUnderTest.choose(21)
        assertTrue(classUnderTest.checkWin())
    }

    @Test
    fun thirdColChosen_ShouldReturnTrue() {
        classUnderTest.choose(3)
        classUnderTest.choose(8)
        classUnderTest.choose(13)
        classUnderTest.choose(18)
        classUnderTest.choose(23)
        assertTrue(classUnderTest.checkWin())
    }

    @Test
    fun diagChosen_ShouldReturnFalse() {
        classUnderTest.choose(1)
        classUnderTest.choose(7)
        classUnderTest.choose(13)
        classUnderTest.choose(19)
        classUnderTest.choose(25)
        assertFalse(classUnderTest.checkWin())
    }
}