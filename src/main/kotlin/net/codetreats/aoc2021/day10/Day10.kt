package net.codetreats.aoc2021.day10

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger


class Day10 : Day<List<String>>(10) {
    private val corresponding = mapOf(')' to '(', ']' to '[', '}' to '{', '>' to '<')

    override val logger: Logger = Logger.forDay(dayOfMonth)

    override fun useDummy(): Boolean = true

    override fun default(): List<String> = listOf()

    override fun convert(input: List<String>): List<String> = input

    override fun run1(): String {
        val corruptScore = mapOf(')' to 3, ']' to 57, '}' to 1197, '>' to 25137)
        var score = 0
        input.forEach { line ->
            val stack = mutableListOf<Char>()
            line@ for (it in line) {
                when {
                    corresponding.values.contains(it) -> stack.add(it)
                    stack.last() == corresponding[it] -> stack.removeLast()
                    else -> {
                        score += corruptScore[it]!!
                        break@line
                    }
                }
            }
        }
        return score.toString()
    }

    override fun run2(): String {
        val fillScore = mapOf('(' to 1L, '[' to 2L, '{' to 3L, '<' to 4L)

        val scores = mutableListOf<Long>()
        input@ for (line in input) {
            val stack = mutableListOf<Char>()
            for (it in line) {
                when {
                    corresponding.values.contains(it) -> stack.add(it)
                    stack.last() == corresponding[it] -> stack.removeLast()
                    else -> continue@input
                }
            }
            scores.add(stack.reversed().map { fillScore[it] }.reduce { sum, it -> (sum ?: 0) * 5 + it!! }!!)
        }
        return scores.sorted()[scores.size / 2].toString()
    }

    fun <T> MutableList<T>.removeLast(): T {
        val last = last()
        removeAt(size - 1)
        return last
    }
}