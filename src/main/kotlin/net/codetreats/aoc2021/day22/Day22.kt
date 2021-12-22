package net.codetreats.aoc2021.day22

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.common.Point
import net.codetreats.aoc2021.common.Point3
import net.codetreats.aoc2021.util.Logger
import java.util.*
import java.util.function.Consumer
import kotlin.collections.ArrayList


class Day22 : Day<List<Cube>>(22) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): List<Cube> = input.map {
        val pattern = "(on|off) x=(-?[0-9]*)..(-?[0-9]*),y=(-?[0-9]*)..(-?[0-9]*),z=(-?[0-9]*)..(-?[0-9]*)".toRegex()
        with(pattern.find(it)!!) {
            Cube(
                groupValues[2].toInt(), groupValues[3].toInt(),
                groupValues[4].toInt(), groupValues[5].toInt(),
                groupValues[6].toInt(), groupValues[7].toInt(),
                groupValues[1] == "on"
            )
        }
    }

    override fun run1(): String {
        val reducedCubes = input.map {
                Cube(it.x1.slice(), it.x2.slice(), it.y1.slice(), it.y2.slice(), it.z1.slice(), it.z2.slice(), it.on)
        }.filter { it.x1 != it.x2 && it.y1 != it.y2 && it.z1 != it.z2 }
        return run(reducedCubes)
    }

    override fun run2(): String = run(input)

    private fun run(cubes: List<Cube>) : String {
        val placed: MutableList<Cube> = ArrayList()
        for (cube in cubes) {
            val todo: MutableList<Cube> = ArrayList()
            if (cube.on) {
                todo.add(cube)
            }
            for (p in placed) {
                p.intersect(cube, !p.on).ifPresent { todo.add(it) }
            }
            placed.addAll(todo)
        }
        return placed.map { it.volume() }.sum().toString()
    }
}