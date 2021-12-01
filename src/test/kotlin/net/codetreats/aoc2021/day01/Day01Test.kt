package net.codetreats.aoc2021.day01;

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day01Test {
    var classUnderTest = Day01();

    @BeforeEach
    fun setup() {

    }

    @Test
    fun testPart01() {
        classUnderTest.init();
        assertEquals("1791", classUnderTest.run1());
    }

    @Test
    fun testPart01_dummyData() {
        classUnderTest.initInput(listOf("199","200","208","210","200","207","240","269","260","263"));
        assertEquals("7", classUnderTest.run1()); }

    @Test
    fun testPart02() {
        classUnderTest.init();
        //assertEquals("5265045", classUnderTest.run2());
    }
}
