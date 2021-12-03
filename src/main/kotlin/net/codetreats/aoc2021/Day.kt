package net.codetreats.aoc2021

import net.codetreats.aoc2021.util.Logger
import java.io.File

abstract class Day<T>(val dayOfMonth: Int) {
    protected abstract val logger: Logger

    protected var input : T = default()

    fun init() {
        init(useDummy())
    }

    fun init(dummy:Boolean) {
        val dir = "src/main/resources/day" + dayOfMonth.toString().padStart(2, '0')
        if (dummy) {
            initInput(read(dir, "dummy.txt"))
        } else {
            initInput(read(dir, "input.txt"))
        }
    }

    fun read(dir: String, file: String): List<String> {
        val file = File(dir, file)
        logger.debug("Read " + file.absolutePath)
        if (!file.exists()) {
            return listOf()
        }
        return file.readLines()
    }

    fun initInput(input: List<String>) {
        this.input = convert(input)
    }


    fun run() {
        init()
        runPart(1) { run1() }
        if (reset()) {
            init()
        }
        runPart(2) { run2() }
    }

    fun runPart(nr: Int, action: ()->String) {
        logger.info("#".repeat(20))
        logger.info("Starting part " + nr)
        logger.info("#".repeat(20))
        logger.info()
        var start = System.currentTimeMillis()
        logger.info("Result: " + action.invoke())
        var end = System.currentTimeMillis()
        logger.info()
        logger.info("Part " + nr + " took " + (end - start) + " millis")
    }

    abstract fun convert(input: List<String>): T

    abstract fun default(): T

    abstract fun run1(): String

    abstract fun run2(): String

    open fun useDummy(): Boolean {
        return false
    }

    open fun reset(): Boolean {
        return false
    }

}