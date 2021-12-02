package net.codetreats.aoc2021

import net.codetreats.aoc2021.day01.Day01
import net.codetreats.aoc2021.day02.Day02
import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import net.codetreats.aoc2021.util.pad
import java.util.*


fun main() {
    Logger.level = Level.DEBUG

    val overrideDay: Int? = null
    val dayOfMonth = overrideDay ?: Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    val paddedDay = dayOfMonth.pad()
    val logger = Logger("Day$paddedDay", "MAIN")


    val days = mutableMapOf<Int, Day<*>>()
    days[1] = Day01()
    days[2] = Day02()

    logger.info("Running AOC for day $dayOfMonth")
    val day = days.get(dayOfMonth)
    if (day == null) {
        logger.error("No code found")
        return
    }

    day.run()

}


