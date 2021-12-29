package net.codetreats.aoc2021.day24

data class Operation(val opCode: String, val op1: Char, val op2: String) {
    private val chars = "abcdefghijklmn"

    companion object {
        var index = 0
        fun from(line: String): Operation {
            val (opCode, op1, op2) = ("$line ").split(" ")
            return Operation(opCode, op1[0], op2)
        }

        fun reset() {
            index = 0
        }
    }

    override fun toString(): String = when (opCode) {
        "inp" -> "$op1 = ${chars[index++]}"
        "mul" -> "$op1 = $op1 * $op2"
        "add" -> "$op1 = $op1 + $op2"
        "div" -> "$op1 = $op1 / $op2"
        "mod" -> "$op1 = $op1 % $op2"
        "eql" -> "$op1 = if ($op1 == $op2) 1 else 0"
        else -> throw IllegalArgumentException()
    }

}