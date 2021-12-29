package net.codetreats.aoc2021.day24

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger
import java.lang.IllegalStateException

class Day24 : Day<List<Operation>>(24) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): List<Operation> {
        Operation.reset()
        return input.map {
            Operation.from(it).also { op -> logger.info(op) }
        }
    }

    private val monads by lazy {
        MonadGenerator().solve()
    }

    override fun run1(): String = monads.last()

    override fun run2(): String = monads.first()
}