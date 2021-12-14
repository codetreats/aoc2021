package net.codetreats.aoc2021.day13

import net.codetreats.aoc2021.common.Point

data class Input(val dots: Set<Point>, val folds: List<Fold>) {
    companion object {
        fun from(lines: List<String>): Input {
            val dots = mutableSetOf<Point>()
            val folds = mutableListOf<Fold>()
            lines.forEach {
                if (it.startsWith("fold")) {
                    folds.add(Fold.from(it))
                }
                if (it.contains(",")) {
                    val parts = it.split(",")
                    dots.add(Point.from(parts[0].toInt(), parts[1].toInt()))
                }
            }
            return Input(dots, folds)
        }
    }
}