package net.codetreats.aoc2021.day01

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger

class Day01 : Day<List<Int> >(1) {

    override val logger: Logger = Logger.forDay(dayOfMonth)

    override fun useDummy(): Boolean = false

    override fun convert(input: List<String>): List<Int> {
        return input.map {
            it.toInt()
        }
    }

    override fun run1(): String {
        var total = 0L
        var last : Int = Integer.MAX_VALUE
        input.forEach {
            if (last < it) {
                total++
            }
            last = it
        }
        return total.toString()
    }

    override fun run2(): String {
        var total = 0L
        var last : Int = Integer.MAX_VALUE
        for (i in 0 .. input.size - 3) {
            val it = input[i] + input[i + 1] + input[i + 2]
            if (last < it) {
                total++
            }
            last = it
        }
        return total.toString()
    }

    override fun default(): List<Int> {
        return listOf()
    }
}
