package net.codetreats.aoc2021.day12

import net.codetreats.aoc2021.common.Edge
import net.codetreats.aoc2021.common.Node
import net.codetreats.aoc2021.util.Logger

class CaveSystem(private val edges: List<Edge>, private val doubleVisitAllowed: Boolean) {
    val logger: Logger = Logger.forDay(12, CaveSystem::class.java.simpleName)

    fun paths(): List<List<Node>> = subPaths(Node("start"), listOf())!!

    private fun subPaths(node: Node, before: List<Node>): List<List<Node>>? {
        if (node.name == "start" && before.isNotEmpty()) {
            return null
        }
        if (node.name == "end") {
            return listOf(listOf(node))
        }
        if (isVisitForbidden(node, before)) {
            return null
        }
        val paths = mutableListOf<List<Node>>()
        val newBefore = ArrayList(before)
        newBefore.add(node)
        edgesFrom(node).map { it.end }.map {node ->
            subPaths(node, newBefore)?.forEach { path ->
                paths.add(path)
            }
        }
        return paths.map { listOf(node) + it }
    }

    private fun isVisitForbidden(node: Node, before: List<Node>): Boolean {
        if (!node.isLittle()) {
            return false
        }
        if (doubleVisitAllowed) {
            val occurrenceMap: Map<String, Int> = before.filter { it.isLittle() }.groupingBy { it.name }.eachCount()
            logger.debug("Check $node in $occurrenceMap")
            return occurrenceMap.containsKey(node.name) && occurrenceMap.values.any { it > 1 }
        } else {
            return before.contains(node)
        }
    }

    private fun edgesFrom(node: Node): List<Edge> = edges.filter { it.start.name == node.name }

    private fun Node.isLittle() = this.name != "start" && this.name.toLowerCase() == this.name
}