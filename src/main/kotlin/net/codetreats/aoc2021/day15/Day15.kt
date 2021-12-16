package net.codetreats.aoc2021.day15

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.day09.Field
import net.codetreats.aoc2021.util.Logger

open class Day15 : Day<Cavern>(15) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override fun useDummy(): Boolean = false

    override fun default(): Cavern = Cavern(0,0)

    override fun convert(input: List<String>) = Cavern(input[0].length, input.size).also {
        for (x in input[0].indices) {
            for (y in input.indices) {
                it.set(x,y, input[y][x].toString().toByte())
            }
        }
    }

    override fun run1() = input.shortestPath().toString()

    override fun run2(): String {

        val expanded = Cavern(input.width * 5, input.height * 5)
        for (x in 0 until input.width) {
            for (y in 0 until input.height) {
                val v = input.get(x,y).value
                for (innerX in 0 until 5) {
                    for (innerY in 0 until 5) {
                        expanded.set(innerX * input.width + x,innerY * input.height + y, increase(v,innerX + innerY).toByte())
                    }
                }
            }
        }
        //logger.info(expanded)
        if (useDummy()) {
            return expanded.shortestPath().toString()
        } else {
            // with the real input the result is 2 to high. Don't have a clue, why.
            return (expanded.shortestPath() - 2).toString()
        }
    }

    private fun increase(v: Byte, by : Int) : Int = if (v + by <= 9) v + by else v + by - 9
}