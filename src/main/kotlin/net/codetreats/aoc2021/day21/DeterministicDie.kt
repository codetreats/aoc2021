package net.codetreats.aoc2021.day21

class DeterministicDie {
    private var value = 0

    var dieCount = 0
        private set

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