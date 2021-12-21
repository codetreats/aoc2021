package net.codetreats.aoc2021.day21

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger

class Day21 : Day<List<Player>>(21) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): List<Player> = input.map {
            val pattern = "Player (-?[0-9]*) starting position: (-?[0-9]*)".toRegex()
            with(pattern.find(it)!!) {
                Player(groupValues[1].toInt(), groupValues[2].toInt(), 0)
            }
    }

    override fun run1(): String {
        val die = DeterministicDie()
        val players = input.map { it.name to it }.toMap().toMutableMap()
        while(players.values.maxBy { it.score }!!.score < 1000) {
            for ((name, player) in players) {
                players[name] = player.move(die.nextThree())
                val score = players[name]!!.score
                if (score >= 1000) {
                    logger.info("Player $name wins with $score!")
                    break
                }
            }
        }
        return (players.values.minBy { it.score }!!.score * die.dieCount).toString()
    }

    override fun run2(): String = QuantumSimulator(input.toSet()).maxWins().toString()
}