package net.codetreats.aoc2021.day24

import net.codetreats.aoc2021.util.Logger

class MonadGenerator {
    private val logger: Logger = Logger.forDay(23, MonadGenerator::class.java.simpleName)

    fun solve(): List<String> {
        val results = mutableSetOf<String>()
        val numbersWithEquals = mutableSetOf<IntermediateResult>()

        for (a in 1..9) {
            for (b in 1..9) {
                for (c in 1..9) {
                    for (d in 1..9) {
                        for (e in 1..9) {
                            for (f in 1..9) {
                                for (g in 1..9) {
                                    for (h in 1..9) {
                                        for (i in 1..9) {

                                            var equalCount = 0
                                            var w = 0
                                            var x = 0
                                            var y = 0
                                            var z = 0

                                            w = a
                                            x = z % 26
                                            x = x + 10
                                            x = if (x == w) 0 else 1
                                            if (x == 0) equalCount++
                                            y = 25 * x + 1
                                            z = z * y
                                            y = w + 5
                                            y = y * x
                                            z = z + y

                                            w = b
                                            x = z % 26
                                            x = x + 13
                                            x = if (x == w) 0 else 1
                                            if (x == 0) equalCount++
                                            y = 25 * x + 1
                                            z = z * y
                                            y = w + 9
                                            y = y * x
                                            z = z + y

                                            w = c
                                            x = z % 26
                                            x = x + 12
                                            x = if (x == w) 0 else 1
                                            if (x == 0) equalCount++
                                            y = 25 * x + 1
                                            z = z * y
                                            y = w + 4
                                            y = y * x
                                            z = z + y

                                            w = d
                                            x = z % 26 // 13
                                            z = z / 26 // 382
                                            x = x - 12 // 1
                                            x = if (x == w) 0 else 1
                                            if (x == 0) equalCount++
                                            y = 25 * x + 1
                                            z = z * y
                                            y = w + 4
                                            y = y * x
                                            z = z + y

                                            w = e
                                            x = z % 26
                                            x = x + 11
                                            x = if (x == w) 0 else 1
                                            if (x == 0) equalCount++
                                            y = 25 * x + 1
                                            z = z * y
                                            y = w + 10
                                            y = y * x
                                            z = z + y

                                            w = f
                                            x = z % 26
                                            z = z / 26
                                            x = x - 13
                                            x = if (x == w) 0 else 1
                                            if (x == 0) equalCount++
                                            y = 25 * x + 1
                                            z = z * y
                                            y = w + 14
                                            y = y * x
                                            z = z + y

                                            w = g
                                            x = z % 26
                                            z = z / 26
                                            x = x - 9
                                            x = if (x == w) 0 else 1
                                            if (x == 0) equalCount++
                                            y = 25 * x + 1
                                            z = z * y
                                            y = w + 14
                                            y = y * x
                                            z = z + y

                                            w = h
                                            x = z % 26
                                            z = z / 26
                                            x = x - 12
                                            x = if (x == w) 0 else 1
                                            if (x == 0) equalCount++
                                            y = 25 * x + 1
                                            z = z * y
                                            y = w + 12
                                            y = y * x
                                            z = z + y

                                            w = i
                                            x = z % 26
                                            x = x + 14
                                            x = if (x == w) 0 else 1
                                            if (x == 0) equalCount++
                                            y = 25 * x + 1
                                            z = z * y
                                            y = w + 14
                                            y = y * x
                                            z = z + y

                                            if (equalCount >= 4) {
                                                numbersWithEquals.add(IntermediateResult(z, a, b, c, d, e, f, g, h, i))
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        logger.info("${numbersWithEquals.size} numbers with at least 4 times x == 0")
        numbersWithEquals.forEach {
            for (j in 1..9) {
                for (k in 1..9) {
                    for (l in 1..9) {
                        for (m in 1..9) {
                            for (n in 1..9) {
                                var w = 0
                                var x = 0
                                var y = 0
                                var z = it.z

                                w = j
                                x = z % 26
                                z = z / 26
                                x = x - 9
                                x = if (x == w) 0 else 1
                                y = 25 * x + 1
                                z = z * y
                                y = w + 14
                                y = y * x
                                z = z + y

                                w = k
                                x = z % 26
                                x = x + 15
                                x = if (x == w) 0 else 1
                                y = 25 * x + 1
                                z = z * y
                                y = w + 5
                                y = y * x
                                z = z + y

                                w = l
                                x = z % 26
                                x = x + 11
                                x = if (x == w) 0 else 1
                                y = 25 * x + 1
                                z = z * y
                                y = w + 10
                                y = y * x
                                z = z + y

                                w = m
                                x = z % 26
                                z = z / 26
                                x = x - 16
                                x = if (x == w) 0 else 1
                                y = 25 * x + 1
                                z = z * y
                                y = w + 8
                                y = y * x
                                z = z + y

                                w = n
                                x = z % 26
                                z = z / 26
                                x = x - 2
                                x = if (x == w) 0 else 1
                                y = 25 * x + 1
                                z = z * y
                                y = w + 15
                                y = y * x
                                z = z + y

                                if (z == 0) {
                                    val monad = "${it.a}${it.b}${it.c}${it.d}${it.e}${it.f}${it.g}${it.h}${it.i}$j$k$l$m$n"
                                    logger.info("Add $monad")
                                    results.add(monad)
                                }
                            }
                        }
                    }
                }
            }
        }
        return results.toList()
    }
}

data class IntermediateResult(val z: Int, val a: Int, val b: Int, val c: Int, val d: Int, val e: Int, val f: Int, val g: Int, val h: Int, val i: Int)