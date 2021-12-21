package net.codetreats.aoc2021.day21

import net.codetreats.aoc2021.util.Logger

data class Player (val name: Int, val position: Int, val score: Int) {
    private val logger: Logger = Logger.forDay(21, Player::class.java.simpleName)

    fun move(fields: Int) : Player {
        var position = (position + fields) % 10
        if (position == 0) {
            position = 10
        }
        val score = score + position
        logger.debug("Player $name moved to $position (score = $score)")
        return Player(name, position, score)
    }
}