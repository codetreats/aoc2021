package net.codetreats.aoc2021.util

class Logger(private val tag: String, private val prefix: String) {
    fun debug(message: Any = "") {
        log(Level.DEBUG, message)
    }

    fun info(message: Any = "") {
        log(Level.INFO, message)
    }

    fun warn(message: Any = "") {
        log(Level.WARN, message)
    }

    fun error(message: Any = "") {
        log(Level.ERROR, message)
    }

    fun log(level: Level, message: Any) {
        if (level >= Logger.level) {
            println("[$tag]($prefix) $message")
        }
    }

    companion object {
        val level: Level = Level.INFO
    }
}

enum class Level(val level: Int) : Comparable<Level> {
    DEBUG(0), INFO(1), WARN(2), ERROR(3)
}
