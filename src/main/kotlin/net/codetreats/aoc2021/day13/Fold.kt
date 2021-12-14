package net.codetreats.aoc2021.day13

data class Fold(val foldX: Boolean, val position: Int) {
    companion object {
        fun from(line: String): Fold {
            val parts = line.replace("fold along ", "").split("=")
            val foldX = parts[0].trim() == "x"
            val position = parts[1].trim().toInt()
            return Fold(foldX, position)
        }
    }
}
