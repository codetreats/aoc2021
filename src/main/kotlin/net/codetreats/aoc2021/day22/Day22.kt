package net.codetreats.aoc2021.day22

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.common.Point3
import net.codetreats.aoc2021.util.Logger

class Day22 : Day<List<Instruction>>(22) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): List<Instruction> = input.map {
        val pattern = "(on|off) x=(-?[0-9]*)..(-?[0-9]*),y=(-?[0-9]*)..(-?[0-9]*),z=(-?[0-9]*)..(-?[0-9]*)".toRegex()

        with(pattern.find(it)!!) {
            Instruction(
                groupValues[2].toInt() ..  groupValues[3].toInt(),
                groupValues[4].toInt() ..  groupValues[5].toInt(),
                groupValues[6].toInt() ..  groupValues[7].toInt(),
                groupValues[1] == "on"
            )
        }
    }


    override fun run1(): String {
        val onCubes = mutableSetOf<Point3>()
        input.forEach {
            for (x in it.xRange) {
                if (x < -50 || x > 50) continue
                for (y in it.yRange) {
                    if (y < -50 || y > 50) continue
                    for (z in it.zRange) {
                        if (z < -50 || z > 50) continue
                        if (it.on) {
                            onCubes.add(Point3.from(x, y, z))
                        } else {
                            onCubes.remove(Point3.from(x, y, z))
                        }
                    }
                }
            }
        }
        return onCubes.size.toString()
    }

    override fun run2(): String {
        return ""
    }
}

data class Instruction(val xRange: IntRange, val yRange: IntRange, val zRange: IntRange, val on: Boolean)