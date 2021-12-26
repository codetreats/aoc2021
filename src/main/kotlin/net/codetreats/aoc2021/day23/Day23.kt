package net.codetreats.aoc2021.day23

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.common.DataPoint
import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger

class Day23 : Day<Position>(23) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

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
        input.forEach {
            logger.info(it)
        }
        return Burrow(input).shortestPath().toString()
    }

    override fun run2(): String {
       /* val burrow = Burrow(input)


        val pos: Position = Position(setOf(
            DataPoint(3, 2, 'A'),
            DataPoint(3, 3, 'A'),
            DataPoint(4, 1, 'B'),
            DataPoint(5, 3, 'B'),
            DataPoint(7, 2, 'C'),
            DataPoint(7, 3, 'C'),
            DataPoint(9, 2, 'D'),
            DataPoint(9, 3, 'D')
        ))

        pos.getEdges(DataPoint(4,1, 'B'))

        return ""*/
        return ""
    }
}