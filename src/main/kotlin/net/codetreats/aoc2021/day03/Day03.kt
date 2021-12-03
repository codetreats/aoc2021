
package net.codetreats.aoc2021.day03

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger

class Day03 : Day<List<String>>(3) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override fun useDebug(): Boolean = false

    override fun convert(input: List<String>): List<String> = input

    override fun run1(): String {
        var gammaString = ""
        for (i in input[0].indices) {
            gammaString += input.criteria(i, true)
        }
        val gamma = gammaString.toInt()
        val epsilon = gammaString.invert().toInt()
        return (gamma * epsilon).toString()
    }

    override fun run2(): String {
        val oxygen = rating(true)
        logger.info("Oxygen = $oxygen")
        val co2 = rating(false)
        logger.info("CO2 = $co2")
        return (oxygen * co2).toString()
    }

    private fun rating(most:Boolean): Int {
        var copy = ArrayList(input)
        for (i in input[0].indices) {
            val criteria = copy.criteria(i, most)
            logger.info("criteria = $criteria for list at pos $i: $copy")
            copy = ArrayList(copy.filter { it[i] == criteria })
            logger.info("Filtered list: $copy")
            if (copy.size <= 1) {
                break
            }
        }
        logger.info("Found oxygen rating: $copy[0]")
        return copy[0].toInt()
    }

    private fun List<String>.criteria(pos: Int, most: Boolean) : Char {
        var count = 0
        val threshold = this.size / 2.0
        this.forEach{
            count += if (it[pos] == '1') 1 else 0
        }
        logger.info("Count = $count >= $threshold?")
        if (count >= threshold) {
            return if (most) '1' else '0'
        } else {
            return if (most) '0' else '1'
        }
    }

    override fun default(): List<String> = listOf()
}

internal fun String.toInt() =  Integer.parseInt(this, 2)

internal fun String.invert() : String = map {
    if (it == '1') {
        '0'
    } else {
        '1'
    }
}.joinToString("")