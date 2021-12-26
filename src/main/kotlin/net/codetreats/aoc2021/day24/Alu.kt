package net.codetreats.aoc2021.day24

import net.codetreats.aoc2021.day23.Burrow
import net.codetreats.aoc2021.util.Logger

class Alu(private val operations: List<Operation>) {
    private val logger: Logger = Logger.forDay(23, Alu::class.java.simpleName)

    fun check(serial: Long) : Boolean {
        val input = Input.from(serial)
        if (!input.isValid()) {
            return false
        }
        return run(input)['z'] == 0
    }

    fun run(input: Input): Map<Char, Int> {
        val vars: MutableMap<Char, Int> = mutableMapOf('w' to 0, 'x' to 0, 'y' to 0, 'z' to 0)
        operations.forEach { op ->
//            logger.info("Run operation $op")
            vars[op.op1] = when (op.opCode) {
                "inp" -> {
                    input.next()
                }
                "add" -> vars[op.op1]!! + op.op2(vars)
                "mul" -> vars[op.op1]!! * op.op2(vars)
                "div" -> vars[op.op1]!! / op.op2(vars)
                "mod" -> vars[op.op1]!! % op.op2(vars)
                "eql" -> if (vars[op.op1]!! == op.op2(vars)) 1 else 0
                else -> throw IllegalArgumentException("Unknown opcode ${op.opCode}")
            }
        }
        return vars
    }

    private fun Operation.op2(vars: Map<Char, Int>) : Int {
        if (op2 == "w" || op2 == "x" || op2 == "y" || op2 == "z") {
            return vars[op2[0]]!!
        }
        return op2.toInt()
    }
}