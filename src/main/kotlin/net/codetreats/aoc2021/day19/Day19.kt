package net.codetreats.aoc2021.day19

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import java.lang.IllegalStateException

class Day19 : Day<List<Scanner>>(19) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): List<Scanner> {
        val scanners = mutableListOf<Scanner>()
        input.forEach { line ->
            if (line.contains("scanner")) {
                scanners.add(Scanner(line))
            } else if (line.trim().isNotEmpty()) {
                scanners.last().addPosition(Position.from(line))
            }
        }
        return scanners
    }
    var linked = LinkedScanners()
    override fun run1(): String {
        val scanner0 = Scanner(input[0].name, Position(0,0,0), Orientation(0,0,0))
        input[0].positions().forEach {
            scanner0.addPosition(it)
        }
        linked.add(scanner0)
        val unlinked = mutableListOf<Scanner>()
        for (i in 1 until input.size) {
            unlinked.add(input[i])
        }
        var somethingChanged = true
        while (somethingChanged) {
            logger.info("Next round - ${unlinked.size} left")
            somethingChanged = false
            ArrayList(unlinked).forEach {scanner ->
                logger.info("Checking ${scanner.name}")
                linked.matches(scanner)?.let {
                    linked.add(it)
                    unlinked.remove(scanner)
                    somethingChanged = true
                }
            }
        }
        if (unlinked.isNotEmpty()) {
            throw IllegalStateException("There are still unlinked scanners")
        }
        return linked.positionCount().toString()
    }

    override fun run2(): String = linked.maxDistance().toString()
}