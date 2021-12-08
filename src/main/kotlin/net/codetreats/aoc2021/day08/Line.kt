package net.codetreats.aoc2021.day08

data class Line(val signalPatterns: List<Set<Char>>, val outputValue: List<Set<Char>>) {
    companion object {
        fun from(line: String) : Line {
            val parts = line.split("|")
            return Line(toList(parts[0]), toList(parts[1]))
        }

        private fun toList(part: String) : List<Set<Char>> {
            val parts = part.trim().split(" ")
            val result = mutableListOf<Set<Char>>()
            parts.forEach {
                result.add(it.trim().toSet())
            }
            return result
        }
    }
}
