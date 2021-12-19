package net.codetreats.aoc2021.day19

class Scanner (val name: String, val position: Position? = null, val orientation: Orientation? = null) {
    private val positions = mutableSetOf<Position>()

    fun positions() : Set<Position> = positions

    fun addPosition(position: Position) {
        positions.add(position)
    }

    override fun toString(): String {
        val buffer = StringBuffer()
        buffer.appendln()
        buffer.appendln(name)
        positions.forEach {
            buffer.appendln(it.toString())
        }
        return buffer.toString()
    }

    fun rotateBy(orientation: Orientation) : Scanner {
        val rotated = Scanner(name, position, orientation)
        positions().forEach {
            rotated.addPosition(it.rotate(orientation))
        }
        return rotated
    }

    fun move(x: Int, y: Int, z: Int): Scanner {
        val moved = Scanner(name, Position(x,y,z),orientation)
        positions().forEach {
            moved.addPosition(Position(it.x + x, it.y + y, it.z + z))
        }
        return moved
    }

    fun distance(scanner: Scanner): Int = position!!.distance(scanner.position!!)
}