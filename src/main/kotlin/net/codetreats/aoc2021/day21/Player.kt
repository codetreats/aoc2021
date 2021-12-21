package net.codetreats.aoc2021.day21

import net.codetreats.aoc2021.day19.LinkedScanners
import net.codetreats.aoc2021.util.Logger

class Player (private val die: Die, private val name: Int, private val start: Int) {
    private val logger: Logger = Logger.forDay(21, Player::class.java.simpleName)

    private var position = start
    private var score = 0

    fun position() = position

    fun score() = score

    fun name() = "Player$name"

    fun move() {
        position = (position + die.nextThree()) % 10
        if (position == 0) {
            position = 10
        }
        score += position
        logger.info("Player $name moved to $position (score = $score)")
    }
}