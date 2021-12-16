package net.codetreats.aoc2021.common

class Dijkstra {
    /**
     * Calculate the minimum distance between startNode and endNode.
     * The algorithm expects, that there are exactly [nodeCount] nodes with names from 0 to [nodeCount - 1]
     * @param: nodeCount the total number of nodes
     * @param: startNOde the name of the start node
     * @param: endNode the name of the end node
     * @param: edges defines all edges. An edge starts at the key of the map and ends in 0 .. n other nodes.
     *         A target node is of type [EdgeDistance],
     *         which contains the name of the target node and the distance between the key and the target
     */
    fun minimalDistance(nodeCount: Int, startNode: Int, endNode: Int, edges: Map<Int, Set<EdgeDistance>>) : Int {
        val distances  = IntArray(nodeCount) { Integer.MAX_VALUE}
        distances[startNode] = 0
        val queue : MutableList<Int> = mutableListOf(0)
        val added = mutableSetOf<Int>(0)
        while(queue.isNotEmpty()) {
            val u : Int = queue.minBy { distances[it] }!!
            queue.remove(u)
            if (u == endNode) {
                return distances[nodeCount - 1]
            }
            edges[u]!!.forEach { v ->
                if (v.node !in queue && v.node !in added) {
                    queue.add(v.node)
                    added.add(v.node)
                }
                if (v.node in queue) {
                    val newDistance = distances[u] + v.weight
                    if (newDistance < distances[v.node]) {
                        distances[v.node] = newDistance
                    }
                }
            }
        }
        throw IllegalStateException("Algorithm finished without result")
    }

    private fun queueMinimum(queue: MutableList<Int>, distances: IntArray): Int {
        var minNode = queue[0]
        var minDistance = Integer.MAX_VALUE
        queue.forEach {
            if (distances[it] < minDistance) {
                minNode = it
                minDistance = distances[it]
            }
        }
        return minNode
    }
}

data class EdgeDistance(val node: Int, val weight: Int)