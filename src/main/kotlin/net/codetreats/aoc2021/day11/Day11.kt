package net.codetreats.aoc2021.day11

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger

class Day11 : Day<List<String>>(11) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override fun useDummy(): Boolean = false

    override fun default(): List<String> = listOf()

    override fun convert(input: List<String>): List<String> = input

    private fun convert(): Cavern = Cavern(input[0].length, input.size).also {
        for (x in input[0].indices) {
            for (y in input.indices) {
                it.set(x,y, Octopus(input[y][x].toString().toInt(), false))
            }
        }
    }

    override fun run1(): String = convert().run(100).toString()

    override fun run2(): String  = convert().runUntilSynced().toString()
}