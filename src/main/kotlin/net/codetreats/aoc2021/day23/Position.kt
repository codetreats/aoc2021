package net.codetreats.aoc2021.day23

import net.codetreats.aoc2021.common.Board
import net.codetreats.aoc2021.common.DataPoint
import net.codetreats.aoc2021.common.Point
import net.codetreats.aoc2021.util.Logger
import java.lang.IllegalArgumentException

class Position(init: Set<DataPoint<Char>>) : HashSet<DataPoint<Char>>(init) {
    private val logger: Logger = Logger.forDay(23, Position::class.java.simpleName)

    private val costs = mapOf('A' to 1, 'B' to 10, 'C' to 100, 'D' to 1000)
    private val hallway = (1..11).map { Point.from(it, 1) }
    private val hallwayPositions = hallway.filter { it.x != 3 && it.x != 5 && it.x != 7 && it.x != 9 }
    private val sideRooms = mapOf(
        'A' to listOf(DataPoint(3, 2, 'A'), DataPoint(3, 3, 'A'), DataPoint(3, 4, 'A'), DataPoint(3, 5, 'A')),
        'B' to listOf(DataPoint(5, 2, 'B'), DataPoint(5, 3, 'B'), DataPoint(5, 4, 'B'), DataPoint(5, 5, 'B')),
        'C' to listOf(DataPoint(7, 2, 'C'), DataPoint(7, 3, 'C'), DataPoint(7, 4, 'C'), DataPoint(7, 5, 'C')),
        'D' to listOf(DataPoint(9, 2, 'D'), DataPoint(9, 3, 'D'), DataPoint(9, 4, 'D'), DataPoint(9, 5, 'D'))
    )

    private fun amp(point: Point): Char? = this.firstOrNull { it.x == point.x && it.y == point.y }?.value

    private fun move(from: DataPoint<Char>, to: DataPoint<Char>): Position {
        val moved = Position(this)
        moved.remove(from)
        moved.add(to)
        return moved
    }

    fun getEdges(amp: DataPoint<Char>): Map<Position, Int> {
        val side0 = sideRooms[amp.value]!![0]
        val side1 = sideRooms[amp.value]!![1]
        val side2 = sideRooms[amp.value]!![2]
        val side3 = sideRooms[amp.value]!![3]
        // Amp in final room
        if (amp == side3 ||
            amp == side2 && amp(side3) == amp.value ||
            amp == side1 && amp(side3) == amp.value && amp(side2) == amp.value ||
            amp == side0 && amp(side3) == amp.value && amp(side2) == amp.value && amp(side1) == amp.value
        ) {
            logger.debug("amp has finished $amp")
            return emptyMap()
        }
        // Can amp reach lower target?
        if (isEmpty(side0) && isEmpty(side1) && isEmpty(side2) && isEmpty(side3)) {
            logger.debug("Search way for $amp to reach side3 $side3")
            getSteps(amp, side3)?.let {
                logger.debug("Found way for $amp to reach $side3")
                return mapOf(move(amp, side3) to (it * costs[amp.value]!!))
            }
        }

        // Can amp reach upper target and lower is correct?
        if (isEmpty(side0) && isEmpty(side1) && isEmpty(side2) && amp(side3) == amp.value) {
            logger.debug("Search way for $amp to reach side2 $side2")
            getSteps(amp, side2)?.let {
                logger.debug("Found way for $amp to reach $side2")
                return mapOf(move(amp, side2) to (it * costs[amp.value]!!))
            }
        }

        // Can amp reach upper target and lower is correct?
        if (isEmpty(side0) && isEmpty(side1) && amp(side2) == amp.value && amp(side3) == amp.value) {
            logger.debug("Search way for $amp to reach $side1")
            getSteps(amp, side1)?.let {
                logger.debug("Found way for $amp to reach side1 $side1")
                return mapOf(move(amp, side1) to (it * costs[amp.value]!!))
            }
        }

        // Can amp reach upper target and lower is correct?
        if (isEmpty(side0) && amp(side1) == amp.value && amp(side2) == amp.value && amp(side3) == amp.value) {
            logger.debug("Search way for $amp to reach side0 $side0")
            getSteps(amp, side0)?.let {
                logger.debug("Found way for $amp to reach $side0")
                return mapOf(move(amp, side0) to (it * costs[amp.value]!!))
            }
        }

        if (amp !in hallway.map { it.toDataPoint(amp.value) }) {
            // Find possible hallway positions
            val result = mutableMapOf<Position, Int>()
            hallwayPositions.forEach { hw ->
                logger.debug("Search way for $amp to reach hallway $hw")
                getSteps(amp, hw)?.let { steps ->
                    val to = move(amp, hw.toDataPoint(amp.value))
                    logger.debug("Found way for $amp to hallway $hw")
                    result.put(to, steps * costs[amp.value]!!)
                }
            }
            return result
        }
        logger.debug("Found no way for $amp")
        return emptyMap()
    }

    private fun getSteps(from: Point, to: Point): Int? {
        logger.debug("Get Steps from $from to $to")
        if (from.x == to.x) {
            throw IllegalArgumentException("From ($from) and to ($to) might not have same x")
        }
        // to hallway
        var steps = 0
        for (i in 1..from.y - 1) {
            if (!isEmpty(Point.from(from.x, i))) {
                logger.debug("To hallway blocked @ ${from.x}, $i")
                return null
            }
            steps++
        }
        // move to x position
        if (from.x < to.x) {
            logger.debug("From < To")

            for (i in from.x + 1..to.x) {
                logger.debug("Check $i, 1")
                // way to hallway is blocked
                if (this.amp(Point.from(i, 1)) != null) {
                    logger.debug("Blocked")
                    return null
                }
                steps++
            }
        } else {
            for (i in to.x..from.x - 1) {
                if (this.amp(Point.from(i, 1)) != null) {
                    logger.debug("Blocked")
                    return null
                }
                steps++
            }
        }
        // move to y position
        logger.debug("For i in ${from.y + 1} << ${to.y}")
        for (i in 2..to.y) {
            if (this.amp(Point.from(to.x, i)) != null) {
                logger.debug("Blocked")
                return null
            }
            steps++
        }
        return steps
    }

    fun asBoard(): Board<Char> {
        val board = Board(13, 7, '#')
        (1..11).forEach { x ->
            board.set(x, 1, '.')
        }
        for (x in listOf(3, 5, 7, 9)) {
            for (y in 2..5) {
                board.set(x, y, '.')
            }
        }
        forEach {
            board.set(it.x, it.y, it.value)
        }
        return board
    }

    private fun isEmpty(point: Point) = this.firstOrNull { it.x == point.x && it.y == point.y } == null

    private fun Point.toDataPoint(value: Char) = DataPoint(x, y, value)
}