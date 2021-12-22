package net.codetreats.aoc2021.day22

import net.codetreats.aoc2021.Day
import net.codetreats.aoc2021.util.Logger
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
        val linked: MutableList<Cube> = ArrayList()
        cubes.forEach { cube ->
            for (p in ArrayList(linked)) {
                p.intersect(cube, !p.on).ifPresent { linked.add(it) }
            }
            if (cube.on) {
                linked.add(cube)
            }
        }
        return linked.map { it.volume() }.sum().toString()
    }
}