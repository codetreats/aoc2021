package net.codetreats.aoc2021.day23

import net.codetreats.aoc2021.common.DataPoint
import net.codetreats.aoc2021.common.Dijkstra
import net.codetreats.aoc2021.common.EdgeDistance
import net.codetreats.aoc2021.common.Point
import net.codetreats.aoc2021.day21.QuantumSimulator
import net.codetreats.aoc2021.util.Logger
import java.lang.IllegalArgumentException
import kotlin.math.min

class Burrow(val start: Position) {
    private val logger: Logger = Logger.forDay(23, Burrow::class.java.simpleName)

    private val endPosition: Position = Position(setOf(
        DataPoint(3, 2, 'A'),
        DataPoint(3, 3, 'A'),
        DataPoint(5, 2, 'B'),
        DataPoint(5, 3, 'B'),
        DataPoint(7, 2, 'C'),
        DataPoint(7, 3, 'C'),
        DataPoint(9, 2, 'D'),
        DataPoint(9, 3, 'D')
    ))
    fun shortestPath(): Int {
        val visitedPositions = mutableListOf<Position>()
        val positionsToCheck = mutableListOf<Position>()
        val edges = mutableMapOf<Int, Set<EdgeDistance>>()
        visitedPositions.add(start)
        positionsToCheck.add(start)

        while (positionsToCheck.isNotEmpty()) {
            val position = positionsToCheck.removeAt(0)
            val positionIndex = visitedPositions.indexOf(position)
            val edgesToAdd: MutableSet<EdgeDistance> = HashSet(edges.getOrDefault(positionIndex, emptySet()))
            val possiblePositions = getEdges(position)
            possiblePositions.forEach {
                logger.info("Found way to")
                logger.info("${it.key.print()}")
                if (!visitedPositions.contains(it.key)) {
                    visitedPositions.add(it.key)
                    positionsToCheck.add(it.key)
                }
                edgesToAdd.add(EdgeDistance(visitedPositions.indexOf(it.key), it.value))
            }
            edges[positionIndex] = edgesToAdd
        }
        val end = visitedPositions.indexOf(endPosition)
        logger.info("Visited: ${visitedPositions.size}")
        logger.info("End-Index: $end")
        if (end < 0) {
            throw IllegalStateException("End position not reached!")
        }
        logger.info("End: ${visitedPositions[end]}")
        return Dijkstra().minimalDistance(visitedPositions.size, 0, end, edges)
    }

    private fun getEdges(from: Position): Map<Position, Int> {
        val result = mutableMapOf<Position, Int>()
        for (point in from) {
            val pointResult = from.getEdges(point)
            pointResult.forEach {
                result[it.key] = min(it.value, result.getOrDefault(it.key, Int.MAX_VALUE))
            }
        }
        return result
    }
}