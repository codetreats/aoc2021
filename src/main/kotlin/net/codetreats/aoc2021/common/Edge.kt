package net.codetreats.aoc2021.common

data class Edge(val start : Node, val end : Node) {
    override fun toString(): String = "$start -> $end"
}