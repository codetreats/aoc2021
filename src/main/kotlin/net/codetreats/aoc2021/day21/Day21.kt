package net.codetreats.aoc2021.day21

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger

class Day21 : Day<List<Player>>(21) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    private val die = Die()

    override fun convert(input: List<String>): List<Player> = input.map {

            val pattern = "Player (-?[0-9]*) starting position: (-?[0-9]*)".toRegex()
            with(pattern.find(it)!!) {
                Player(die, groupValues[1].toInt(), groupValues[2].toInt())
            }
    }

    override fun run1(): String {
        while(input.maxBy { it.score() }!!.score() < 1000) {
            for (player in input) {
                player.move()
                if (player.score() >= 1000) {
                    logger.info("Player ${player.name()} wins with ${player.score()}!")
                    break
                }
            }
        }
        return (input.minBy { it.score() }!!.score() * die.dieCount()).toString()
    }

    override fun run2(): String {
        return ""
    }
}