package net.codetreats.aoc2021.day14

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger
import kotlin.text.StringBuilder

class Day14 : Day<Map<String, List<String>>>(14) {
    private var template = ""

    override val logger: Logger = Logger.forDay(dayOfMonth)

    override fun useDummy(): Boolean = true

    override fun default(): Map<String, List<String>> = mapOf()

    override fun convert(input: List<String>): Map<String, List<String>> {
        template = input[0]
        var result = mutableMapOf<String, List<String>>()
        for (i in 2 until input.size) {
            val (from, to) = input[i].split(" -> ")
            result[from] = listOf("${from[0]}${to[0]}", "${to[0]}${from[1]}")
        }
        return result
    }

    override fun run1(): String = runSteps(10).toString()

    override fun run2(): String = runSteps(40).toString()

    private fun runSteps(amount: Int): Long {
        var chunks = templateInChunks()
        for (step in 1..amount) {
            var nextChunks = mutableMapOf<String, Long>()
            chunks.forEach { (key, amount) ->
                input[key]!!.forEach { nextChunks.increase(it, amount) }
            }
            chunks = nextChunks
            logger.info("After step $step: $chunks")
        }
        return calculateResult(chunks)
    }

    private fun templateInChunks(): Map<String, Long> {
        var chunks = mutableMapOf<String, Long>()
        for (i in 1 until template.length) {
            val key = "${template[i - 1]}${template[i]}"
            chunks[key] = 1 + (chunks[key] ?: 0)
        }
        logger.info("Input ($template) as Chunks: $chunks")
        return chunks
    }

    private fun calculateResult(chunks: Map<String, Long>): Long {
        val map = mutableMapOf<Char, Long>()

        chunks.forEach {
            map.increase(it.key[0], it.value)
            map.increase(it.key[1], it.value)
        }

        // all but the first and the last char are counted twice, as the chunks are overlapping
        map.increase(template.first())
        map.increase(template.last())
        val max = map.values.max()!! / 2
        val min = map.values.min()!! / 2

        return max - min
    }

    private fun <T> MutableMap<T, Long>.increase(pos: T, add: Long = 1) {
        this[pos] = getOrDefault(pos, 0) + add
    }
}