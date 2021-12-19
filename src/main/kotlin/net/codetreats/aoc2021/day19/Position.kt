package net.codetreats.aoc2021.day19

import kotlin.math.abs

data class Position(val x: Int, val y: Int, val z: Int) {
    companion object {
        fun from(line: String) : Position {
            val (x,y,z) = line.split(",")
            return Position(x.toInt(), y.toInt(), z.toInt())
        }
    }

    override fun toString(): String = "$x,$y,$z"

    fun rotate(orientation: Orientation) = this.rotateX(orientation.xRot).rotateY(orientation.yRot).rotateZ(orientation.zRot)

    private fun rotateX(steps: Int) = when(steps) {
        1 -> Position(x, -z, y)
        2 -> Position(x, -y, -z)
        3 -> Position(x, z, -y)
        else -> Position(x, y, z)
    }

    private fun rotateY(steps: Int) = when(steps) {
        1 -> Position(-z, y, x)
        2 -> Position(-x, y, -z)
        3 -> Position(z, y, -x)
        else -> Position(x, y, z)
    }

    private fun rotateZ(steps: Int) = when(steps) {
        1 -> Position(-y, x, z)
        2 -> Position(-x, -y, z)
        3 -> Position(y, -x, -z)
        else -> Position(x, y, z)
    }

    fun distance(position: Position): Int = abs(x - position.x) + abs(y - position.y) + abs(z - position.z)
}
