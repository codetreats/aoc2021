package net.codetreats.aoc2021.day08

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger

class Day08 : Day<List<Line>>(8) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): List<Line> = input.map { Line.from(it) }

    override fun run1(): String =
        input.map { it.outputValue.count { it.size in listOf(2, 3, 4, 7) } }.sum().toString()

    override fun run2(): String =
        input.map { Decoder(it).decode() }.sum().toString()
}