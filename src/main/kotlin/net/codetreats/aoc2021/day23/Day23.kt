package net.codetreats.aoc2021.day23

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.common.DataPoint
import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger

class Day23 : Day<Position>(23) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = true

    override fun convert(input: List<String>): Position {
        val set = mutableSetOf<DataPoint<Char>>()
        for (y in input.indices) {
            for (x in input[y].indices) {
                val c = input[y][x]
                if (c == 'A' || c == 'B' || c == 'C' || c == 'D') {
                    set.add(DataPoint(x, y, c))
                }
            }
        }
        return Position(set)
    }

    override fun run1(): String {
        Logger.level = Level.INFO
        val points = HashSet(input)
        points.add(DataPoint(3, 4, 'A'))
        points.add(DataPoint(3, 5, 'A'))
        points.add(DataPoint(5, 4, 'B'))
        points.add(DataPoint(5, 5, 'B'))
        points.add(DataPoint(7, 4, 'C'))
        points.add(DataPoint(7, 5, 'C'))
        points.add(DataPoint(9, 4, 'D'))
        points.add(DataPoint(9, 5, 'D'))
        return Burrow(Position(points)).shortestPath().toString()
    }

    override fun run2(): String {
        Logger.level = Level.INFO
        val points = HashSet(input)

        val x3 = points.get(3, 3)
        points.remove(x3)
        points.add(DataPoint(3, 5, x3.value))
        val x5 = points.get(5, 3)
        points.remove(x5)
        points.add(DataPoint(5, 5, x5.value))
        val x7 = points.get(7, 3)
        points.remove(x7)
        points.add(DataPoint(7, 5, x7.value))
        val x9 = points.get(9, 3)
        points.remove(x9)
        points.add(DataPoint(9, 5, x9.value))

        points.add(DataPoint(3, 3, 'D'))
        points.add(DataPoint(3, 4, 'D'))
        points.add(DataPoint(5, 3, 'C'))
        points.add(DataPoint(5, 4, 'B'))
        points.add(DataPoint(7, 3, 'B'))
        points.add(DataPoint(7, 4, 'A'))
        points.add(DataPoint(9, 3, 'A'))
        points.add(DataPoint(9, 4, 'C'))

        return Burrow(Position(points)).shortestPath().toString()
    }

    private fun Set<DataPoint<Char>>.get(x: Int, y: Int): DataPoint<Char> = filter { it.x == x && it.y == y }[0]

}