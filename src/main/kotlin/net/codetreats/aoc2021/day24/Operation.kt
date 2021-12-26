package net.codetreats.aoc2021.day24

data class Operation(val opCode : String, val op1: Char, val op2: String) {
    companion object {
        fun from(line: String) : Operation {
            val (opCode, op1, op2) = ("$line ").split(" ")
            return Operation(opCode,op1[0],op2)
        }
    }
}