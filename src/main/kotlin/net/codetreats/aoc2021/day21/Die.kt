package net.codetreats.aoc2021.day21

class Die {
    private var value = 0

    private var dieCount = 0

    fun currentValue() = value

    fun dieCount() = dieCount

    private fun next() : Int {
        dieCount++
        value++
        if (value > 100) {
            value = 1
        }
        return value
    }

    fun nextThree() = next() + next() + next()
}