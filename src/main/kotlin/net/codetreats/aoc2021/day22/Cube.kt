package net.codetreats.aoc2021.day22

import net.codetreats.aoc2021.common.Point3.Companion.from
import net.codetreats.aoc2021.day22.Cube
import net.codetreats.aoc2021.common.Point3
import java.util.*
import kotlin.math.max
import kotlin.math.min

class Cube(val x1: Int, val x2: Int, val y1: Int, val y2: Int, val z1: Int, val z2: Int, val on: Boolean) {
    fun volume(): Long {
        val sign = if (on) 1 else -1
        return sign * (x2 - x1 + 1L) * (y2 - y1 + 1L) * (z2 - z1 + 1L)
    }

    fun intersect(c: Cube, on: Boolean): Optional<Cube> {
        if (x1 > c.x2 || x2 < c.x1 || y1 > c.y2 || y2 < c.y1 || z1 > c.z2 || z2 < c.z1) {
            return Optional.empty()
        }
        return Optional.of(
            Cube(
                max(x1, c.x1), min(x2, c.x2),
                max(y1, c.y1), min(y2, c.y2),
                max(z1, c.z1), min(z2, c.z2), on
            )
        )
    }
}


fun Int.slice(): Int {
    if (this > 50) {
        return 50
    }
    if (this < -50) {
        return -50
    }
    return this
}