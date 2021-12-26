package net.codetreats.aoc2021.day24

data class Input(val inputs: List<Int>) {

    companion object {
        fun from(input: Long) : Input {
            val inpString = input.toString()
            if (inpString.endsWith("11111")) {
                println("$input")
            }
            return Input(inpString.map { it.toInt() - 48 })
        }
    }

    fun isValid() = !inputs.contains(0)

    var position = 0

    fun next() = inputs[position++]
}