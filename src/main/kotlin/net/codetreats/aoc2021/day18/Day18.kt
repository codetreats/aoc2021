package net.codetreats.aoc2021.day18

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger
import kotlin.math.max

class Day18 : Day<List<Tree>>(18) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): List<Tree> = input.map { Tree.from(it) }

    override fun run1(): String {
        var sum: Tree = Leaf(0)
        input.forEach { sum = sum.add(it) }
        return sum.magnitude().toString()
    }

    override fun run2(): String {
        var magnitude = 0
        for (i in input.indices) {
            for (j in input.indices) {
                magnitude = max(magnitude, input[i].add(input[j]).magnitude())
            }
        }
        return magnitude.toString()
    }
}