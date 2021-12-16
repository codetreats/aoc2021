package net.codetreats.aoc2021.day13

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.common.Board
import net.codetreats.aoc2021.common.Point
import net.codetreats.aoc2021.util.Logger

class Day13 : Day<Input>(13) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): Input = Input.from(input)

    override fun run1(): String {
        return fold(input.dots, input.folds[0]).also { Paper.from(it).log() }.size.toString()
    }

    override fun run2(): String {
        var folded = input.dots
        input.folds.forEach { folded = fold(folded, it) }
        val paper = Paper.from(folded)
        paper.log()
        return paper.translate()
    }

    private fun fold(input: Set<Point>, fold: Fold): Set<Point> =
        if (fold.foldX) {
            input.map { foldX(it, fold.position) }.toSet()
        } else {
            input.map { foldY(it, fold.position) }.toSet()
        }

    private fun foldX(point: Point, position: Int) : Point {
        var value = point.x
        if (point.x > position) {
            value = point.x - 2 * (point.x - position)
        }
        return Point.from(value, point.y)
    }

    private fun foldY(point: Point, position: Int) : Point{
        var value = point.y
        if (point.y > position) {
            value = point.y - 2 * (point.y - position)
        }
        return Point.from(point.x, value)
    }
}

