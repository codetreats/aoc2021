package net.codetreats.aoc2021.day13

import net.codetreats.aoc2021.common.Board
import net.codetreats.aoc2021.common.Point
import net.codetreats.aoc2021.util.Logger
import java.util.*

class Paper(width: Int, height: Int) : Board<Char>(width, height, '.') {
    // Reverse engineered
    private val translationMap = mutableMapOf(
        "(0,1)(0,2)(0,3)(0,4)(1,0)(1,5)(2,0)(2,5)(3,1)(3,4)" to "C",
        "(0,4)(1,5)(2,0)(2,5)(3,0)(3,1)(3,2)(3,3)(3,4)" to "J",
        "(0,0)(0,1)(0,2)(0,3)(0,4)(0,5)(1,2)(2,1)(2,3)(2,4)(3,0)(3,5)" to "K",
        "(0,0)(0,1)(0,2)(0,3)(0,4)(0,5)(1,0)(1,2)(1,5)(2,0)(2,2)(2,5)(3,1)(3,3)(3,4)" to "B",
        "(0,1)(0,2)(0,3)(0,4)(0,5)(1,0)(1,3)(2,0)(2,3)(3,1)(3,2)(3,3)(3,4)(3,5)" to "A",
        "(0,0)(0,1)(0,2)(0,3)(0,4)(0,5)(1,0)(1,3)(2,0)(2,3)(3,1)(3,2)" to "P",
        "(0,0)(0,1)(0,2)(0,3)(0,4)(1,0)(1,4)(2,0)(2,4)(3,0)(3,4)(4,0)(4,1)(4,2)(4,3)(4,4)" to "O"
    )

    val logger: Logger = Logger.forDay(13, Paper::class.java.simpleName)

    fun log() {
        logger.info(this)
    }

    fun translate() : String {
        val chars  = mutableListOf<SortedSet<Point>>()
        var offset = 0
        while ( offset < width) {
            val char = sortedSetOf<Point>()
            for (x in offset until offset + 5) {
                for (y in 0 until height) {
                    if (getOrNull(x,y)?.value == '#') {
                        char.add(Point.from(x-offset, y))
                    }
                }
            }
            chars.add(char)
            // Each char has a width of 4 (plus 1 space between chars)
            offset += 5
        }
        return chars.joinToString("") { translationMap[it.toKeyString()] ?: it.toKeyString() }
    }

    private fun Set<Point>.toKeyString() = this.joinToString("") { "(${it.x},${it.y})" }

    companion object {
        fun from(points: Set<Point>) : Paper {
            val paper = Paper(points.maxX(), points.maxY())
            points.forEach { paper.set(it.x, it.y, '#') }
            return paper
        }
    }
}

fun Set<Point>.maxX() = map { it.x }.max()!! + 1
fun Set<Point>.maxY() = map { it.y }.max()!! + 1