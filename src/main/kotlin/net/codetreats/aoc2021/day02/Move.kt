package net.codetreats.aoc2021.day02

data class Move(val forward: Int, val down: Int) {
    companion object {
        fun from(line: String) : Move {
            val parts = line.split(" ")
            val type = parts[0]
            val value = parts[1]
            return when (type) {
                "forward" -> Move(value.toInt(), 0)
                "down" -> Move(0, value.toInt())
                "up" -> Move(0, -1 * value.toInt())
                else -> throw IllegalArgumentException("Unknown line: $line")
            }
        }
    }
}