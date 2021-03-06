package net.codetreats.aoc2021.day16

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger

class Day16 : Day<String>(16) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    private val translate = mapOf(
        '0' to "0000", '1' to "0001", '2' to "0010", '3' to "0011",
        '4' to "0100", '5' to "0101", '6' to "0110", '7' to "0111",
        '8' to "1000", '9' to "1001", 'A' to "1010", 'B' to "1011",
        'C' to "1100", 'D' to "1101", 'E' to "1110", 'F' to "1111"
    )

    override val useDummy = false

    override fun convert(input: List<String>): String {
        val result = StringBuilder()
        input[0].forEach { result.append(translate[it]) }
        return result.toString()
    }

    override fun run1(): String = Package.from(input).versionSum().toString()

    override fun run2(): String = Package.from(input).value().toString()
}