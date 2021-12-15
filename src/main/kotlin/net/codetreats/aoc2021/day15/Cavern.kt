package net.codetreats.aoc2021.day15

import net.codetreats.aoc2021.common.Board
import net.codetreats.aoc2021.util.Logger

class Cavern(width: Int, height: Int) : Board<Byte>(width, height, 0) {
    val logger: Logger = Logger.forDay(15, Cavern::class.java.simpleName)

    init {
        logger.info("Create cavern $width x $height")
    }


    fun shortestPath() : Int {
        val nodes = width * height
        val edges: Array<MutableMap<Int,Byte>> = Array(nodes) { mutableMapOf<Int,Byte>() }
        for ( x in 0 until width) {
            for ( y in 0 until height) {
                neighbors(x, y).forEach {
                    edges[position(x,y)][position(it.x, it.y)] = it.value
                }
            }
        }
        val shortestPathes = dijkstra(0, edges, nodes)
        //printShortest(shortestPathes)
        return shortestPathes[width * height - 1]
    }

    private fun position(x: Int, y: Int) = y * width + x

    private fun printShortest(shortestPathes: IntArray) {
        val print = object : Board<Int>(width, height, 0) {
            override fun valueToString(value: Int): String {
                return value.toString().padStart(4, ' ')
            }
        }
        for (x in 0 until width) {
            for (y in 0 until height) {
                print.set(x,y, shortestPathes[position(x,y)])
            }
        }
        logger.debug("$print")
    }

    private fun dijkstra(startIndex: Int, edges: Array<MutableMap<Int,Byte>>, nodeCount: Int) : IntArray {
        // Initialize single source
        val distances = IntArray(nodeCount) { Integer.MAX_VALUE }
        val predecessors = IntArray(nodeCount) { -1 }
        distances[startIndex] = 0

        val S: MutableList<Int> = ArrayList()
        val Q: MutableList<Int> = (0 until nodeCount).toMutableList()

        // Iterations
        while (Q.isNotEmpty()) {
            val u: Int = extractMin(Q, distances)
            S.add(u)

            edges[u].entries.forEach {  node ->
                if (distances[node.key] > distances[u] + node.value) {
                    distances[node.key] = distances[u] + node.value
                    predecessors[node.key] = u
                }
            }
        }
        return distances
    }

    private fun extractMin(Q: MutableList<Int>, d: IntArray): Int {
        var minNode = Q[0]
        var minDistance: Int = d[0]

        Q.forEach {
            if (d[it] < minDistance) {
                minNode = it
                minDistance = d[it]
            }
        }

        Q.remove(minNode)
        return minNode
    }
}