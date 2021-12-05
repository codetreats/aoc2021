package net.codetreats.aoc2021.day05

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger

class Day05 : Day<List<Line>>(5) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override fun useDummy(): Boolean = false

    override fun default(): List<Line> = listOf()

    override fun convert(input: List<String>): List<Line> = input.map { Line(it) }

    override fun run1(): String = atLeastCovered(2, false).toString()

    override fun run2(): String = atLeastCovered(2, true).toString()

    private fun atLeastCovered(atLeast: Int, useDiagonals: Boolean) : Int {
        val points = mutableMapOf<Point, Int>()
        input.filter { useDiagonals || !it.diagonal }.forEach { line ->
            line.points.forEach {
                points[it] = 1 + (points[it] ?: 0)
            }
        }
        return points.filter { it.value >= atLeast }.size
    }
}