package net.codetreats.aoc2021.day08

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DecoderTest {
    @Test
    fun line1_ShouldBeEqualTo8394() {
        val classUnderTest = Decoder(Line.from("be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe"))
        assertEquals(1, classUnderTest.decode("be".toSet()))
        assertEquals(3, classUnderTest.decode("cefdb".toSet()))
        assertEquals(4, classUnderTest.decode("gcbe".toSet()))
        assertEquals(8, classUnderTest.decode("fdgacbe".toSet()))
        assertEquals(9, classUnderTest.decode("cefbgd".toSet()))
        assertEquals(8394, classUnderTest.decode())
    }

    @Test
    fun line2_ShouldBeEqualTo9781() {
        val classUnderTest = Decoder(Line.from("edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc"))
        assertEquals(9781, classUnderTest.decode())
    }
}
