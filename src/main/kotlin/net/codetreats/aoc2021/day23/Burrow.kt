package net.codetreats.aoc2021.day23

import net.codetreats.aoc2021.common.DataPoint
import net.codetreats.aoc2021.common.Dijkstra
import net.codetreats.aoc2021.common.EdgeDistance
import net.codetreats.aoc2021.util.Logger
import kotlin.math.min

class Burrow(val start: Position) {
    private val logger: Logger = Logger.forDay(23, Burrow::class.java.simpleName)

    private val endPosition: Position = Position((2..5).map {
        listOf(DataPoint(3, it, 'A'), DataPoint(5, it, 'B'), DataPoint(7, it, 'C'), DataPoint(9, it, 'D'))
    }.flatten().toSet())

    fun shortestPath(): Int {
        val visitedPositions = mutableMapOf<Position, Int>()
        val positionsToCheck = mutableListOf<Position>()
        val edges = mutableMapOf<Int, Set<EdgeDistance>>()

        visitedPositions[start] = 0
        positionsToCheck.add(start)
        logger.info("Start with ${start.asBoard()}")

        while (positionsToCheck.isNotEmpty()) {
            val position = positionsToCheck.removeAt(0)
            val positionIndex = visitedPositions[position]!!
            val edgesToAdd: MutableSet<EdgeDistance> = HashSet(edges.getOrDefault(positionIndex, emptySet()))
            val possiblePositions = getEdges(position)
            possiblePositions.forEach {
                logger.debug("Found way to")
                logger.debug("${it.key.asBoard()}")
                if (!visitedPositions.containsKey(it.key)) {
                    visitedPositions[it.key] = visitedPositions.size
                    positionsToCheck.add(it.key)
                }
                edgesToAdd.add(EdgeDistance(visitedPositions[it.key]!!, it.value))
            }
            edges[positionIndex] = edgesToAdd
        }
        val end = visitedPositions[endPosition]!!
        logger.info("End-Index: $end")
        if (end < 0) {
            throw IllegalStateException("End position not reached!")
        }
        val shortest = Dijkstra().shortestPath(visitedPositions.size, 0, end, edges)
        shortest.shortestPath(0, end).forEach {node ->
            visitedPositions.filter { it.value == node }.forEach {
                logger.info(it.key.asBoard())
            }
        }
        return shortest.length
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