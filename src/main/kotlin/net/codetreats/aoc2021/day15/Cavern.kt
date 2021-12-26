package net.codetreats.aoc2021.day15

import net.codetreats.aoc2021.common.Board
import net.codetreats.aoc2021.common.Dijkstra
import net.codetreats.aoc2021.common.EdgeDistance
import net.codetreats.aoc2021.util.Logger

class Cavern(width: Int, height: Int) : Board<Byte>(width, height, 0) {
    val logger: Logger = Logger.forDay(15, Cavern::class.java.simpleName)

    fun shortestPath() : Int {
        logger.info("Prepare dijkstra")
        val edges: MutableMap<Int, Set<EdgeDistance>> = mutableMapOf()
        for ( x in 0 until width) {
            for ( y in 0 until height) {
                val set = mutableSetOf<EdgeDistance>()
                neighbors(x, y).forEach {
                    set.add(EdgeDistance(position(it.x,it.y), it.value.toInt()))
                }
                edges[position(x,y)] = set
            }
        }
        logger.info("Run dijkstra")
        return Dijkstra().shortestPath(width * height, 0, width * height - 1, edges).length
    }
}