package net.codetreats.aoc2021.day17

import net.codetreats.aoc2021.util.Logger
import kotlin.math.max

class ProbeLauncher(private val fromX: Int, private val toX: Int, private val lowerY: Int, private val higherY: Int) {
    val logger: Logger = Logger.forDay(17, ProbeLauncher::class.java.simpleName)
    private val xRange = fromX .. toX
    private val yRange = lowerY .. higherY

    fun highestAltitude() : Int = possibleShots().maxBy { it.maxAltitude }!!.also { logger.info(it) }.maxAltitude

    fun possibleShots(): Set<Shot> {
        val shots = mutableSetOf<Shot>()
        for (x in 1 .. toX) { // max xSpeed can be toX
            for (y in lowerY .. (lowerY * (-1))) { // as the flight curve is a parabel, each shot will return some time to altitude 0 with a speed of y. Therefore the y-speed must be <= lowerY
                simulate(x,y)?.let { shots.add(it) }
            }
        }
        return shots
    }

    private fun simulate(x: Int, y: Int): Shot? {
        logger.debug("simulateShot $x,$y")
        var xSpeed = x
        var ySpeed = y
        var xPos = 0
        var yPos = 0
        var maxAlt = 0
        while(xPos <= toX && yPos >= lowerY) {
            xPos += xSpeed
            yPos += ySpeed
            maxAlt = max(yPos, maxAlt)
            xSpeed = max(0, xSpeed - 1)
            ySpeed--
            if (xPos in xRange && yPos in yRange) {
                logger.debug("Found valid shot ($x,$y) hits ($xPos,$yPos) with an max alt = $maxAlt")
                return Shot(x,y, maxAlt)
            }
        }
        return null
    }
}

data class Shot(val xSpeed: Int, val ySpeed: Int, val maxAltitude: Int)