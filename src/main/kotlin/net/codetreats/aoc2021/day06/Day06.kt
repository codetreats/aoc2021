package net.codetreats.aoc2021.day06

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger

class Day06 : Day<List<Int>>(6) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override fun useDummy(): Boolean = false

    override fun default(): List<Int> = listOf()

    override fun convert(input: List<String>): List<Int> = input[0].split(",").map { it.toInt() }

    override fun run1(): String = simulate(80).toString()

    override fun run2(): String = simulate(256).toString()

    private fun simulate(days: Int) : Long {
        var fishes = inputSortedBySlots()
        for (day in 1..days) {
            val birthing = fishes[0]
            for (i in 0 .. 7) {
                // move fishes to next lower slot
                fishes[i] = fishes[i + 1]
            }
            fishes[6] = fishes[6] + birthing // reset fish counter to 6 for all fishes that created new fishes
            fishes[8] = birthing // create new fishes for each birthing fish
        }
        return fishes.sum()
    }

    /**
     * Sort the fishes into slots that indicates, how many days they have left until the create a new fish
     * Therefore there are exactly 9 slots (0 - 8)
     */
    private fun inputSortedBySlots() : MutableList<Long> {
        val fishes = mutableListOf<Long>()
        for (i in 0 .. 8) {
            fishes.add(0L)
        }
        input.forEach {
            fishes[it] = fishes[it] + 1
        }
        return fishes
    }
}