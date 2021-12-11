package net.codetreats.aoc2021.day09

import net.codetreats.aoc2021.common.Board
import net.codetreats.aoc2021.common.IntPoint

class Field(width: Int, height: Int) : Board<Int>(width, height, 0) {
    fun getLowPoints() : List<IntPoint> {
        val lowPoints = mutableListOf<IntPoint>()
        for (x in 0 until width) {
            for (y in 0 until height) {
                if (isLowPoint(x, y)) {
                    lowPoints.add(get(x, y))
                }
            }
        }
        return lowPoints
    }

    fun getBasins(): List<Set<IntPoint>> = getLowPoints().map { getBasin(it) }

    private fun getBasin(point: IntPoint) : Set<IntPoint> {
        val basin = mutableSetOf<IntPoint>()
        basin.add(point)
        var oldSize: Int
        do {
            oldSize = basin.size
            ArrayList(basin).forEach {
                neighbors(it.x, it.y).forEach {n ->
                    if (n.valueOrMax() < 9) {
                        basin.add(n)
                    }
                }
            }
        } while (oldSize != basin.size)
        return basin
    }
    private fun isLowPoint(x: Int, y: Int) : Boolean {
        val p = get(x, y)
        neighbors(x, y).forEach {
            if (p.value >= it.valueOrMax()) {
                return false
            }
        }
        return true
    }

    private fun IntPoint?.valueOrMax() = this?.value ?: Int.MAX_VALUE
}