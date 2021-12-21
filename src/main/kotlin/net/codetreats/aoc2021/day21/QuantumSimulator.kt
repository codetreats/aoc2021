package net.codetreats.aoc2021.day21

import net.codetreats.aoc2021.util.Logger
import kotlin.math.max

class QuantumSimulator(private val players: Set<Player>) {
    private val logger: Logger = Logger.forDay(21, QuantumSimulator::class.java.simpleName)
    private val diceRolls = setOf(3 to 1, 4 to 3, 5 to 6, 6 to 7, 7 to 6, 8 to 3, 9 to 1)

    fun maxWins(): Long {
        logger.info("Start sim for $players")
        var games = mutableMapOf<Set<Player>, Long>()
        val playerWins = mutableMapOf(1 to 0L, 2 to 1L)
        games[players] = 1L
        var round = 0
        while (games.isNotEmpty()) {
            logger.info("################## NEXT (${games.keys.size}) ###############")
            val index = (round++ % 2) + 1

            var copy = mutableMapOf<Set<Player>, Long>()
            for ((eyes, times) in diceRolls) {
                HashMap(games).forEach { (players, amount) ->
                    val player = players.find { it.name == index }!!.move(eyes)
                    if (player.score >= 21) {
                        playerWins[index] = playerWins[index]!! + times * amount
                    } else {
                        val key = setOf(player) + players.filter { it.name != index }
                        copy[key] = copy.getOrDefault(key, 0) + times * amount
                    }
                }
            }
            games = copy
        }
        logger.info("Result $playerWins")
        return playerWins.values.max()!!
    }
}