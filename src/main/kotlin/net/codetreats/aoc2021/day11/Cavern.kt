package net.codetreats.aoc2021.day11

import net.codetreats.aoc2021.common.Board
import net.codetreats.aoc2021.common.DataPoint
import net.codetreats.aoc2021.util.Logger

class Cavern(width: Int, height: Int) : Board<Octopus>(width, height, Octopus(0, false)) {
    val logger: Logger = Logger.forDay(11, Cavern::class.java.simpleName)

    fun run(steps: Int) : Long {
        var result = 0L
        logger.info("Before:$this")
        for (i in 1 .. steps) {
            increase()
            result += flash()
            logger.info("After $i:$this")
        }
        return result
    }

    fun runUntilSynced() : Long {
        var stepResult = 0
        logger.info("Before:$this")
        var steps = 0
        while (stepResult != width * height) {
            steps++
            content.forEach { it.increase() }
            stepResult = flash().toInt()
            logger.info("After $steps:$this")
        }
        return steps.toLong()
    }

    private fun flash() : Long {
        var result = 0L
        var flashing = getFlashing()
        while(flashing.isNotEmpty()) {
            result += flashing.size
            flashing.forEach {
                it.value.flash()
                neighbors(it.x, it.y, true).forEach {neighbor ->
                    neighbor.value.neighborFlashed()
                }
            }
            flashing = getFlashing()
        }
        return result
    }

    private fun getFlashing() : List<DataPoint<Octopus>> {
        val flashing = mutableListOf<DataPoint<Octopus>>()
        for (x in 0 until width) {
            for (y in 0 until height) {
                val point : DataPoint<Octopus> = get(x,y)
                if (point.value.value > 9) {
                    flashing.add(point)
                }
            }
        }
        return flashing
    }

    override fun valueToString(value: Octopus): String {
        if (value.value == 0) {
            return "#"
        }
        if (value.value >= 10) {
            return "_"
        }
        return value.value.toString()
    }
}

data class Octopus(var value: Int, var flashed: Boolean) {
    fun increase() {
        value++
        flashed  = false
    }

    fun flash() {
        value = 0
        flashed = true
    }

    fun neighborFlashed() {
        if (!flashed) {
            value++
        }
    }
}