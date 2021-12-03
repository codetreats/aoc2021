package net.codetreats.aoc2021.day03

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger
import java.util.*
import kotlin.math.pow

class Day03WithBitSet : Day<List<BitSet>>(3) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override fun useDummy(): Boolean = false

    private var lineLength = 0

    override fun convert(input: List<String>): List<BitSet> = input.map {line ->
        if (line.length > lineLength) {
            lineLength = line.length
        }
        val bitSet = BitSet(line.length)
        for (i in line.indices) {
            if (line[i] === '1') {
                bitSet.set(i)
            }
        }
        bitSet
    }

    override fun run1(): String {
        val gamma = BitSet(lineLength)
        for (i in 0 until lineLength) {
            var count = 0
            input.forEach{
                count += if (it.get(i)) 1 else 0
            }
            if (count > input.size / 2) {
                logger.info("Gamma[$i] = 1")
                gamma.set(i)
            } else {
                logger.info("Gamma[$i] = 0")
            }
        }

        val gammaVal = gamma.longValue()
        logger.info("Gamma = $gammaVal")
        val epsilon = gamma.invert()
        val epsilonVal = epsilon.longValue()
        logger.info("Epsilon = $epsilonVal")

        return (gammaVal * epsilonVal).toString()
    }

    override fun run2(): String {
        return 0L.toString()
    }

    override fun default(): List<BitSet> {
        return listOf()
    }

    internal fun BitSet.longValue() : Long {
        var value = 0.0
        for (i in lineLength - 1 downTo 0 ) {
            val add = if (get(i)) 2.0.pow(lineLength - 1 - i) else 0.0
            value += add
        }
        return value.toLong()
    }

    private fun BitSet.invert() : BitSet = this.also { flip(0, lineLength) }
}
