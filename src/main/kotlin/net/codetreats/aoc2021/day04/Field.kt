package net.codetreats.aoc2021.day04

const val PADDING = 2

data class Field(val number: Int) {
    private var marked = ' '

    fun mark(number: Int) {
        if (number == this.number) {
            marked = '#'
        }
    }

    fun reset() {
        marked = ' '
    }

    fun isMarked() = marked == '#'

    override fun toString() : String = "$marked${number.toString().padStart(PADDING, '0')}$marked"
}