package net.codetreats.aoc2021.day20

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger

class Day20 : Day<Image>(20) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    private val run1repeats = 2
    private val run2repeats = 50

    override fun convert(input: List<String>): Image {
        val enhancement = input[0].map { if (it == '#') 1 else 0 }.map { it.toByte() }

        val image = Image(input[2].length + 2 * run2repeats, input.size + 2 * run2repeats, enhancement)
        for (y in 2 until  input.size) {
            for (x in input[y].indices) {
                image.set(x + run2repeats, y + run2repeats, if (input[y][x] == '#') 1 else 0)
            }
        }
        return image
    }

    override fun run1(): String {
        var enhanced = input
        logger.info("Image0: $enhanced")
        for (i in 1..run1repeats) {
            enhanced = enhanced.enhance()
            logger.debug("Image$i: $enhanced")
        }
        return enhanced.litPixels().toString()
    }

    override fun run2(): String {
        var enhanced = input
        logger.info("Image0: $enhanced")
        for (i in 1..run2repeats) {
            enhanced = enhanced.enhance()
            logger.debug("Image$i: $enhanced")
        }
        return enhanced.litPixels().toString()
    }
}