package net.codetreats.aoc2021.day02

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger

class Day02 : Day<List<Move>>(2) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = true

    override fun convert(input: List<String>): List<Move> = input.map { Move.from(it) }

    override fun run1(): String {
        var forward = 0L
        var down = 0L
        input.forEach {
            forward += it.forward
            down += it.down
        }
        return (forward * down).toString()
    }

    override fun run2(): String {
        var forward = 0L
        var down = 0L
        var aim = 0L
        input.forEach {
            aim += it.down
            forward += it.forward
            down += it.forward * aim
        }
        return (forward * down).toString()
    }
}
