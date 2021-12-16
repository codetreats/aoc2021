package net.codetreats.aoc2021.day12

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.common.Edge
import net.codetreats.aoc2021.common.Node
import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import kotlin.math.log

class Day12 : Day<List<Edge>>(12) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    init {
        Logger.level = Level.INFO
    }

    override val useDummy = false

    override fun convert(input: List<String>): List<Edge> = input.map {
        val start = Node(it.split("-")[0])
        val end = Node(it.split("-")[1])
        listOf(Edge(start, end), Edge(end, start))
    }.flatten()

    override fun run1(): String {
        logger.info(input)
        val paths = CaveSystem(input, false).paths()
        paths.forEach {
            logger.info(it)
        }
        return paths.size.toString()
    }

    override fun run2(): String {
        val paths = CaveSystem(input, true).paths()
        paths.forEach {
            logger.info(it)
        }
        return paths.size.toString()
    }
}