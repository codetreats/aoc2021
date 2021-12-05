package net.codetreats.aoc2021.day05

class Line(line: String) {
    val points : List<Point>
    val diagonal: Boolean
    private var length: Int = 0

    init {
        val parts = line.split("->")
        val start = Point.from(parts[0])
        val end = Point.from(parts[1])
        val stepX = stepSize(end.x - start.x)
        val stepY = stepSize(end.y - start.y)
        diagonal = stepX * stepY != 0
        val points = mutableListOf<Point>()
        for (i in 0..length) {
            points.add(Point(start.x + i * stepX, start.y + i * stepY))
        }
        this.points = points.toList()
    }

    private fun stepSize(diff: Int) = when {
        diff < 0 -> {
            length = -1 *diff
            -1
        }
        diff > 0 -> {
            length = diff
            1
        }
        else -> 0
    }

    override fun toString(): String {
        return points.toString()
    }
}

data class Point(val x : Int, val y: Int) {
    companion object {
        fun from(point: String) : Point{
            val parts = point.trim().split(",")
            return Point(parts[0].toInt(), parts[1].toInt())
        }
    }
}