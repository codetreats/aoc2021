package net.codetreats.aoc2021.day22

import java.util.*
import kotlin.math.max
import kotlin.math.min

class Cube(val x1: Int, val x2: Int, val y1: Int, val y2: Int, val z1: Int, val z2: Int, val on: Boolean) {
    fun volume(): Long {
        val sign = if (on) 1 else -1
        return sign * (x2 - x1 + 1L) * (y2 - y1 + 1L) * (z2 - z1 + 1L)
    }

    fun intersect(other: Cube, on: Boolean): Optional<Cube> {
        if (x1 > other.x2 || x2 < other.x1 || y1 > other.y2 || y2 < other.y1 || z1 > other.z2 || z2 < other.z1) {
            return Optional.empty()
        }
        return Optional.of(
            Cube(
                max(x1, other.x1), min(x2, other.x2),
                max(y1, other.y1), min(y2, other.y2),
                max(z1, other.z1), min(z2, other.z2),
                on
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