package net.codetreats.aoc2021.day15

import net.codetreats.aoc2021.common.Board
import net.codetreats.aoc2021.util.Logger

class Cavern(width: Int, height: Int) : Board<Byte>(width, height, 0) {
    val logger: Logger = Logger.forDay(15, Cavern::class.java.simpleName)

    init {
        logger.info("Create cavern $width x $height")
    }


    fun shortestPath() : Int {
        logger.info("Prepare dijkstra")

        val nodes = width * height
        val edges: MutableMap<Int, Set<Int>> = mutableMapOf()
        val weights: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()
        for ( x in 0 until width) {
            for ( y in 0 until height) {
                val set = mutableSetOf<Int>()
                neighbors(x, y).forEach {
                    set.add(position(it.x,it.y))
                    weights[Pair(position(x,y), position(it.x, it.y))] = it.value.toInt()
                }
                edges[position(x,y)] = set
            }
        }


        val graph = Graph<Int>(
            (0 until width * height).toSet(),
            edges,
            weights
        )

        logger.info("Run dijkstra")
        val shortestPathes = dijkstra(graph,0)
        //printShortest(shortestPathes)
        logger.info("Calculate shortest")
        val path = shortestPath(shortestPathes, 0, width * height -1)
        logger.info("Shortest path: $path")
        return path.map { content[it]}.sum() - content[0]
    }

    fun <T> dijkstra(graph: Graph<T>, start: T): Map<T, T?> {
        val S: MutableSet<T> = mutableSetOf() // a subset of vertices, for which we know the true distance

        val delta = graph.vertices.map { it to Int.MAX_VALUE }.toMap().toMutableMap()
        delta[start] = 0

        val previous: MutableMap<T, T?> = graph.vertices.map { it to null }.toMap().toMutableMap()

        while (S != graph.vertices) {
            val v: T = delta
                .filter { !S.contains(it.key) }
                .minBy { it.value }!!
                .key

            graph.edges.getValue(v).minus(S).forEach { neighbor ->
                val newPath = delta.getValue(v) + graph.weights.getValue(Pair(v, neighbor))

                if (newPath < delta.getValue(neighbor)) {
                    delta[neighbor] = newPath
                    previous[neighbor] = v*
                }
            }

            S.add(v)
        }

        return previous.toMap()
    }

    fun <T> shortestPath(shortestPathTree: Map<T, T?>, start: T, end: T): List<T> {
        fun pathTo(start: T, end: T): List<T> {
            if (shortestPathTree[end] == null) return listOf(end)
            return listOf(pathTo(start, shortestPathTree[end]!!), listOf(end)).flatten()
        }

        return pathTo(start, end)
    }
}

data class Graph<T>(
    val vertices: Set<T>,
    val edges: Map<T, Set<T>>,
    val weights: Map<Pair<T, T>, Int>
)