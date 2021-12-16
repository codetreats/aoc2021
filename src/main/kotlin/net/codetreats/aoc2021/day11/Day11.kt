package net.codetreats.aoc2021.day11

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger

class Day11 : Day<Cavern>(11) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): Cavern = Cavern(input[0].length, input.size).also {
        for (x in input[0].indices) {
            for (y in input.indices) {
                it.set(x,y, Octopus(input[y][x].toString().toInt(), false))
            }
        }
    }

    override fun run1(): String = input.run(100).toString()

    override fun run2(): String  = input.runUntilSynced().toString()
}