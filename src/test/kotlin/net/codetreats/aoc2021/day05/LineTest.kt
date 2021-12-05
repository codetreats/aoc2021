package net.codetreats.aoc2021.day05

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LineTest {
    lateinit var classUnderTest: Line

    @Test
    fun horizontalLine_ShouldBeCorrect() {
        classUnderTest = Line("0,0 -> 5,0")
        println(classUnderTest)
        assertEquals(6, classUnderTest.points.size)
        assertTrue(classUnderTest.points.contains(Point(0,0)))
        assertTrue(classUnderTest.points.contains(Point(1,0)))
        assertTrue(classUnderTest.points.contains(Point(2,0)))
        assertTrue(classUnderTest.points.contains(Point(3,0)))
        assertTrue(classUnderTest.points.contains(Point(4,0)))
        assertTrue(classUnderTest.points.contains(Point(5,0)))
    }

    @Test
    fun lineWithoutLength_ShouldBeCorrect() {
        classUnderTest = Line("5,0 -> 5,0")
        println(classUnderTest)
        assertEquals(1, classUnderTest.points.size)
        assertTrue(classUnderTest.points.contains(Point(5,0)))
    }

    @Test
    fun verticalLine_ShouldBeCorrect() {
        classUnderTest = Line("0,8 -> 0,5")
        println(classUnderTest)
        assertEquals(4, classUnderTest.points.size)
        assertTrue(classUnderTest.points.contains(Point(0,5)))
        assertTrue(classUnderTest.points.contains(Point(0,6)))
        assertTrue(classUnderTest.points.contains(Point(0,7)))
        assertTrue(classUnderTest.points.contains(Point(0,8)))
    }

    @Test
    fun diagonalLine_ShouldBeCorrect() {
        classUnderTest = Line("4,8 -> 1,5")
        println(classUnderTest)
        assertEquals(4, classUnderTest.points.size)
        assertTrue(classUnderTest.points.contains(Point(4,8)))
        assertTrue(classUnderTest.points.contains(Point(3,7)))
        assertTrue(classUnderTest.points.contains(Point(2,6)))
        assertTrue(classUnderTest.points.contains(Point(1,5)))
    }
}