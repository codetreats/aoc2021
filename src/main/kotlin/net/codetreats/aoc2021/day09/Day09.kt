package net.codetreats.aoc2021.day09

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger

class Day09 : Day<Field>(9) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = true

    override fun convert(input: List<String>) = Field(input[0].length, input.size).also {
        for (x in input[0].indices) {
            for (y in input.indices) {
                it.set(x,y, input[y][x].toString().toInt())
            }
        }
    }

    override fun run1(): String = input.getLowPoints().map { it.value + 1 }.sum().toString()

    override fun run2(): String {
        val basins = input.getBasins().map { it.size }.sorted().reversed()
        return (basins[0] * basins[1] * basins[2]).toString()
    }
}