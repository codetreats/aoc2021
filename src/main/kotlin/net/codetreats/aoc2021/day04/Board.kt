package net.codetreats.aoc2021.day04

class Board(val dimension: Int) {
    private val fields = mutableListOf<Field>()

    private var latestChosen = -1

    fun addField(number: Int) {
        fields.add(Field(number))
    }

    fun reset() {
        fields.forEach {
            it.reset()
        }
    }

    fun checkWin() : Boolean = check(true) || check(false)

    private fun check(row: Boolean) : Boolean {
        for (i in 0 until dimension) {
            var allMarked = true
            for (j in 0 until dimension) {
                val position = if (row) i * dimension + j else j * dimension + i
                if (!fields[position].isMarked()) {
                    allMarked = false
                }
            }
            if (allMarked) {
                return true
            }
        }
        return false
    }

    fun calculateScore() = latestChosen * fields.filter { ! it.isMarked() }.sumBy { it.number }

    fun choose(number: Int) {
        latestChosen = number
        fields.forEach {
            it.mark(number)
        }
    }

    override fun toString(): String {
        var result = "\n"
        for((index, field) in fields.iterator().withIndex()) {
            if (index % dimension == 0) {
                result += "\n"
            }
            result += "$field "
        }
        return result
    }
}