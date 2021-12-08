package net.codetreats.aoc2021.day08

import net.codetreats.aoc2021.util.Logger

class Decoder(val line: Line) {
    val logger: Logger = Logger.forDay(8, Decoder::class.java.simpleName)

    private val decodingMap = mutableMapOf<Set<Char>, Int>()

    init {
        // sort patterns by size and segments (Chars) by amount
        val segmentCounts = mutableMapOf<Char, Int>()
        val patternSizes = mutableMapOf<Int, MutableList<Set<Char>>>()
        line.signalPatterns.forEach {set ->
            val list = patternSizes[set.size] ?: mutableListOf()
            list.add(set)
            patternSizes[set.size] = list

            set.forEach { c ->
                val count = segmentCounts[c] ?: 0
                segmentCounts[c] = count + 1
            }
        }

        // fill unique patterns -> list contains exactly 1 element
        decodingMap[patternSizes[2]!!.first()] = 1
        decodingMap[patternSizes[3]!!.first()] = 7
        decodingMap[patternSizes[4]!!.first()] = 4
        decodingMap[patternSizes[7]!!.first()] = 8

        // look for numbers with 5 segment: 2, 3, 5
        val listSize5 = patternSizes[5]!!

        // 3 must contain 1 completely
        val nr3 = listSize5.find { it.containsAll ( patternSizes[2]!!.first() ) }!!
        decodingMap[nr3] = 3
        listSize5.remove(nr3)

        //  2 and 5 remaining
        // the segment labeled with f in the example is the only one that is used 9 times
        // therefore the char that appears 9 times in the patterns must be the replacement for 'f' and
        // the digit that contains this segment, must be number 5
        val f : Char = segmentCounts.keys.first { segmentCounts[it] == 9 }
        if (listSize5[0].contains(f)) {
            decodingMap[listSize5[0]] = 5
            decodingMap[listSize5[1]] = 2
        } else {
            decodingMap[listSize5[0]] = 2
            decodingMap[listSize5[1]] = 5
        }

        // look for numbers with 6 segment: 0, 6, 9
        val listSize6 = patternSizes[6]!!

        // 6 must not contain 1 completely
        val nr6 = listSize6.find { ! it.containsAll ( patternSizes[2]!!.first() ) }!!
        decodingMap[nr6] = 6
        listSize6.remove(nr6)

        //  0 and 9 remaining
        // the segment labeled with e is the only one that is used 4 times
        // therefore the char that appears 4 times in the patterns must be the replacement for 'e' and
        // the digit that contains this segment, must be number 0
        val e : Char = segmentCounts.keys.first { segmentCounts[it] == 4 }
        if (listSize6[0].contains(e)) {
            decodingMap[listSize6[0]] = 0
            decodingMap[listSize6[1]] = 9
        } else {
            decodingMap[listSize6[0]] = 9
            decodingMap[listSize6[1]] = 0
        }
    }
    fun decode() : Int = with(line.outputValue) {
        decode(this[0]) * 1000 + decode(this[1]) * 100 + decode(this[2]) * 10 + decode(this[3])
    }

    fun decode(number : Set<Char>): Int {
        return decodingMap[number] ?: throw IllegalStateException("Number $number not found in $decodingMap")
    }
}