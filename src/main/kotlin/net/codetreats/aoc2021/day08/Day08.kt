package net.codetreats.aoc2021.day08

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger

class Day08 : Day<List<String>>(8) {
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