package net.codetreats.aoc2021.day24

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger
import java.lang.IllegalStateException

class Day24 : Day<List<Operation>>(24) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): List<Operation> = input.map { Operation.from(it) }

    override fun run1(): String {
        val alu = Alu(input)
        var  input = 99_999_999_999_999L
        logger.info(Input.from(input))

        while (true) {
            if (alu.check(input)) {
                return input.toString()
            }
            input--
        }
        throw IllegalStateException("This point should never be reached")
    }

    override fun run2(): String {
        return ""
    }
}