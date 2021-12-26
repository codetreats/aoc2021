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
        val visitedPositions = mutableMapOf<Position, Int>()
        val positionsToCheck = mutableListOf<Position>()
        val edges = mutableMapOf<Int, Set<EdgeDistance>>()

        visitedPositions[start] = 0
        positionsToCheck.add(start)
        logger.info("Find $start in ${visitedPositions.keys}")

        while (positionsToCheck.isNotEmpty()) {
            val position = positionsToCheck.removeAt(0)
            val positionIndex = visitedPositions[position]!!
            val edgesToAdd: MutableSet<EdgeDistance> = HashSet(edges.getOrDefault(positionIndex, emptySet()))
            val possiblePositions = getEdges(position)
            possiblePositions.forEach {
                logger.info("Found way to")
                logger.info("${it.key.print()}")
                if (!visitedPositions.containsKey(it.key)) {
                    visitedPositions[it.key] = visitedPositions.size
                    positionsToCheck.add(it.key)
                }
                edgesToAdd.add(EdgeDistance(visitedPositions[it.key]!!, it.value))
            }
            edges[positionIndex] = edgesToAdd
        }
        visitedPositions.forEach {
            logger.info("Visited: ${it.value} : ${it.key}")
        }

        val end = visitedPositions[endPosition]!!
        logger.info("End-Index: $end")
        if (end < 0) {
            throw IllegalStateException("End position not reached!")
        }
        return Dijkstra().shortestPath(visitedPositions.size, 0, end, edges).length
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