package net.codetreats.aoc2021.day04

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger
import java.util.*
import kotlin.collections.ArrayList

class Day04 : Day<List<Board>>(4) {
    private var inputs: MutableList<Int> = mutableListOf()

    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): List<Board> {
        inputs.addAll(input[0].split(",").map { it.toInt() })
        val boards = mutableListOf<Board>()
        var board = Board(5)
        for (i in 2 until input.size) {
            val line = input[i]
            if (line.trim().isEmpty()) {
                boards.add(board)
                board = Board(5)
                continue
            }

            for (number in line.split(" ")) {
                if (number.trim().isEmpty()) {
                    continue
                }
                board.addField(number.toInt())
            }
        }
        boards.add(board)
        return boards
    }

    override fun run1(): String {
        inputs.forEach { number ->
            input.forEach { board ->
                board.choose(number)
                if (board.checkWin()) {
                    logger.info("Boards: $input")
                    return board.calculateScore().toString()
                }
            }
        }
        return ""
    }

    override fun run2(): String {
        val boards = ArrayList(input)
        boards.forEach { it.reset() }
        inputs.forEach { number ->
            logger.info("Next number: $number")

            boards.forEach { board ->
                board.choose(number)
                if (board.checkWin() && boards.size == 1) {
                    logger.info("Latest board: ${boards[0]}")
                    return boards[0].calculateScore().toString()
                }
            }
            boards.removeAll { it.checkWin() }
            logger.info("${boards.size} Boards $boards")


        }
        return boards.toString()
    }
}