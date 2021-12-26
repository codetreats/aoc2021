package net.codetreats.aoc2021.day25

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.common.Board
import net.codetreats.aoc2021.common.Point
import net.codetreats.aoc2021.util.Logger

class Day25 : Day<Cucumbers>(25) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): Cucumbers {
        val down = mutableSetOf<Point>()
        val right = mutableSetOf<Point>()

        for (y in input.indices) {
            for (x in input[y].indices) {
                if (input[y][x] == 'v') {
                    down.add(Point.from(x,y))
                }
                if (input[y][x] == '>') {
                    right.add(Point.from(x,y))
                }
            }
        }
        return Cucumbers(input[0].length, input.size, down, right)
    }

    override fun run1(): String {
        var old: Cucumbers
        var next = input.copy()
        logger.info("Before ${input.asBoard()}")
        var step = 0
        var changed: Boolean
        do {
            step++
            changed = false
            old = next
            val down = mutableSetOf<Point>()
            val right = mutableSetOf<Point>()

            ArrayList(old.right).forEach {
                val inc = Point.from((it.x + 1) % input.width, it.y)
                if (!old.right.contains(inc) && !old.down.contains(inc)) {
                    changed = true
                    right.add(inc)
                } else {
                    right.add(it)
                }
            }
            ArrayList(old.down).forEach {
                val inc = Point.from(it.x, (it.y + 1) % input.height)
                if (!right.contains(inc) && !old.down.contains(inc)) {
                    changed = true
                    down.add(inc)
                } else {
                    down.add(it)
                }
            }
            next = Cucumbers(input.width, input.height, down, right)
        //    logger.info("Step $i: ${next.print()}")
        } while (changed)
        return "$step"
    }

    override fun run2(): String {
        return ""
    }
}

data class Cucumbers(val width: Int, val height: Int, val down: Set<Point>, val right: Set<Point>) {
    fun asBoard() : Board<Char> {
        val board = Board<Char>(width, height, '.')
        down.forEach {
            board.set(it.x, it.y, 'v')
        }
        right.forEach {
            board.set(it.x, it.y, '>')
        }
        return board
    }
}