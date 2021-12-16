package net.codetreats.aoc2021.day16

import net.codetreats.aoc2021.util.Logger

data class Package(
    val bitsConsumed: Int,
    val version: Int,
    val type: Int,
    val literal: Long?,
    val subPackages: List<Package>
) {
    fun versionSum(): Int = version + subPackages.map { it.versionSum() }.sum()

    fun value(): Long = when (type) {
        0 -> subPackages.map { it.value() }.sum()
        1 -> subPackages.map { it.value() }.reduce { op1, op2 -> op1 * op2 }
        2 -> subPackages.map { it.value() }.min()!!
        3 -> subPackages.map { it.value() }.max()!!
        4 -> literal!!
        5 -> if (subPackages[0]!!.value() > subPackages[1]!!.value()) 1 else 0
        6 -> if (subPackages[0]!!.value() < subPackages[1]!!.value()) 1 else 0
        7 -> if (subPackages[0]!!.value() == subPackages[1]!!.value()) 1 else 0
        else -> throw IllegalArgumentException("Unknown type $type")
    }

    companion object {
        val logger: Logger = Logger.forDay(16, Package::class.java.simpleName)

        fun from(binaryString: String): Package {
            logger.info("New package from $binaryString")
            val version: Int = binaryString.substring(0, 3).toInt(2)
            val type: Int = binaryString.substring(3, 6).toInt(2)

            logger.info("Version: $version - Type: $type")
            val substring = binaryString.substring(6)
            val pkg = if (type == 4) {
                val literal = parseLiteral(substring)
                Package(literal.bitsConsumed + 6, version, type, literal.literal, emptyList())
            } else {
                parseOperator(version, type, substring)
            }
            logger.info("Created new package from $binaryString: $pkg")
            return pkg
        }

        private fun parseOperator(version: Int, type: Int, substring: String): Package {
            val subPackages = mutableListOf<Package>()
            var bitsConsumed = 0
            var headerConsumed : Int
            var condition: () -> Boolean

            if (substring[0] == '0') {
                headerConsumed = 16
                condition = { subPackages.map { it.bitsConsumed }.sum() < substring.substring(1, 16).toInt(2) }
            } else {
                headerConsumed = 12
                condition = { subPackages.size < substring.substring(1, 12).toInt(2) }
            }

            var subStringRest = substring.substring(headerConsumed)
            bitsConsumed += headerConsumed
            while (condition()) {
                val p = from(subStringRest)
                subPackages.add(p)
                bitsConsumed += p.bitsConsumed
                subStringRest = subStringRest.substring(p.bitsConsumed)
            }
            return Package(bitsConsumed + 6, version, type, null, subPackages)
        }

        private fun parseLiteral(substring: String): Literal {
            logger.info("parseLiteral: $substring")

            var number = ""
            var consumed = 0
            for (i in 0 until substring.length / 5) {
                number += substring.substring(i * 5 + 1, i * 5 + 5)
                consumed += 5
                if (substring[i * 5] == '0') {
                    break
                }
            }
            val literal = number.toLong(2)
            return Literal(literal, consumed)
        }
    }
}

data class Literal(val literal: Long, val bitsConsumed: Int)