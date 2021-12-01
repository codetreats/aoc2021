package net.codetreats.aoc2021;

import net.codetreats.aoc2021.day01.Day01
import net.codetreats.aoc2021.util.Logger
import java.util.*


fun main() {
    val overrideDay: Int? = null;
    val dayOfMonth = overrideDay ?: Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    val paddedDay = dayOfMonth.toString().padStart(2, '0')
    val logger = Logger("Day$paddedDay", "MAIN")


    val days = mutableMapOf<Int, Day<*>>();
    days[1] = Day01();

    logger.info("Running AOC for day $dayOfMonth");
    val day = days.get(dayOfMonth);
    if (day == null) {
        logger.error("No code found");
        return;
    }

    day.run();

}


