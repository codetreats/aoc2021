package net.codetreats.aoc2021.day07

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger
import kotlin.math.abs

class Day07 : Day<List<Int>>(7) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override fun useDummy(): Boolean = false

    override fun default(): List<Int> = listOf()

    override fun convert(input: List<String>): List<Int> = input[0].split(",").map { it.toInt() }

    override fun run1(): String = calculateFuel(false).toString()

    override fun run2(): String = calculateFuel(true).toString()

    private fun calculateFuel(sumUp: Boolean) =
        IntRange(input.min()!!,input.max()!!).map { calculateFuel(it, sumUp) }.min()

    private fun calculateFuel(pos: Int, sumUp: Boolean) =
        input.map { abs(pos - it) }.map { if (sumUp) sumUp(it) else it }.sum()

    private fun sumUp(until : Int) = until * (until + 1) / 2
}