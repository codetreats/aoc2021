package net.codetreats.aoc2021

import net.codetreats.aoc2021.day01.Day01
import net.codetreats.aoc2021.day02.Day02
import net.codetreats.aoc2021.day03.Day03
import net.codetreats.aoc2021.day04.Day04
import net.codetreats.aoc2021.day05.Day05
import net.codetreats.aoc2021.day06.Day06
import net.codetreats.aoc2021.day07.Day07
import net.codetreats.aoc2021.day08.Day08
import net.codetreats.aoc2021.day09.Day09
import net.codetreats.aoc2021.day10.Day10
import net.codetreats.aoc2021.day11.Day11
import net.codetreats.aoc2021.day12.Day12
import net.codetreats.aoc2021.day13.Day13
import net.codetreats.aoc2021.day14.Day14
import net.codetreats.aoc2021.day15.Day15
import net.codetreats.aoc2021.day16.Day16
import net.codetreats.aoc2021.day17.Day17
import net.codetreats.aoc2021.day18.Day18
import net.codetreats.aoc2021.day19.Day19
import net.codetreats.aoc2021.day20.Day20
import net.codetreats.aoc2021.day21.Day21
import net.codetreats.aoc2021.day22.Day22
import net.codetreats.aoc2021.day23.Day23
import net.codetreats.aoc2021.day24.Day24
import net.codetreats.aoc2021.day25.Day25
import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import net.codetreats.aoc2021.util.pad
import java.util.*


fun main() {
    Logger.level = Level.DEBUG

    val overrideDay: Int? = 1
    val dayOfMonth = overrideDay ?: Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    val paddedDay = dayOfMonth.pad()
    val logger = Logger("Day$paddedDay", "MAIN")

    val days = mutableMapOf<Int, Day<*>>()
    days[1] = Day01()
    days[2] = Day02()
    days[3] = Day03()
    days[4] = Day04()
    days[5] = Day05()
    days[6] = Day06()
    days[7] = Day07()
    days[8] = Day08()
    days[9] = Day09()
    days[10] = Day10()
    days[11] = Day11()
    days[12] = Day12()
    days[13] = Day13()
    days[14] = Day14()
    days[15] = Day15()
    days[16] = Day16()
    days[17] = Day17()
    days[18] = Day18()
    days[19] = Day19()
    days[20] = Day20()
    days[20] = Day20()
    days[21] = Day21()
    days[22] = Day22()
    days[23] = Day23()
    days[24] = Day24()
    days[25] = Day25()

    logger.system("Running AOC for day $dayOfMonth")

    days[dayOfMonth]!!.run()
}