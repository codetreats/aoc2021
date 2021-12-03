package net.codetreats.aoc2021.day14

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger

class Day14 : Day<List<String>>(14) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override fun useDummy(): Boolean = true

    override fun default(): List<String> = listOf()

    override fun convert(input: List<String>): List<String> = input

    override fun run1(): String {
        return ""
    }

    override fun run2(): String {
        return ""
    }
}