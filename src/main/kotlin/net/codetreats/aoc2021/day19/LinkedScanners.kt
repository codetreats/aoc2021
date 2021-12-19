package net.codetreats.aoc2021.day19

import net.codetreats.aoc2021.util.Logger
import kotlin.math.max

const val MATCH_COUNT = 12

class LinkedScanners {

    private val logger: Logger = Logger.forDay(19, LinkedScanners::class.java.simpleName)

    private val scanners = mutableListOf<Scanner>()
    private val positions = mutableSetOf<Position>()

    fun positionCount() = positions.size

    fun add(scanner: Scanner) {
        scanners.add(scanner)
        positions.addAll(scanner.positions())
    }

    fun matches(scanner: Scanner): Scanner? {
        for (xRot in 0 .. 3) {
            for (yRot in 0 .. 3) {
                for (zRot in 0 .. 3) {
                    val orientation = Orientation(xRot, yRot, zRot)
                    val rotated = scanner.rotateBy(orientation)
                    positions.forEach { linkedPosition ->
                        rotated.positions().forEach { scannerPosition ->
                            val moved = rotated.move(
                                linkedPosition.x - scannerPosition.x,
                                linkedPosition.y - scannerPosition.y,
                                linkedPosition.z - scannerPosition.z
                            )
                            logger.debug("[${scanner.name}] in $orientation moved to ${moved.position}")
                            if (moved.positions().intersect(positions).size >= MATCH_COUNT) {
                                logger.info("Found match: ${moved.name}@${moved.position} in ${moved.orientation}")
                                return moved
                            }
                        }
                    }
                }
            }
        }
        return null
    }

    fun maxDistance() : Int {
        var distance = 0
        for (i in 0 until scanners.size) {
            for (j in i until scanners.size) {
                distance = max(distance, scanners[i].distance(scanners[j]))
            }
        }
        return distance
    }
}