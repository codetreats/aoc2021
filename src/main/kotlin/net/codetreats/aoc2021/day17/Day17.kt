package net.codetreats.aoc2021.day17

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger

class Day17 : Day<ProbeLauncher>(17) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): ProbeLauncher {
        val pattern = "target area: x=(-?[0-9]*)..(-?[0-9]*), y=(-?[0-9]*)..(-?[0-9]*)".toRegex()
        return with(pattern.find(input[0])!!) {
            ProbeLauncher(groupValues[1].toInt(), groupValues[2].toInt(), groupValues[3].toInt(), groupValues[4].toInt())
        }
    }

    override fun run1(): String = input.highestAltitude().toString()

    override fun run2(): String = input.possibleShots().size.toString()
}