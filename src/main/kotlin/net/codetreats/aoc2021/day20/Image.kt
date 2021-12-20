package net.codetreats.aoc2021.day20

import net.codetreats.aoc2021.common.Board
import net.codetreats.aoc2021.util.Logger

class Image(width: Int, height: Int, private val enhancement: List<Byte>) : Board<Byte>(width, height, 0) {
    private val logger: Logger = Logger.forDay(20, Image::class.java.simpleName)

    fun enhance() : Image {
        val enhanced = Image(width, height, enhancement)
        for (x in 0 until width) {
            for (y in 0 until  height) {
                var enhanceIndex = ""
                for (innerY in -1 .. 1) {
                    for (innerX in -1 .. 1) {
                        enhanceIndex += getOrDefault(x + innerX, y + innerY)
                    }
                }
                val enhancedPixel = enhancement[enhanceIndex.toInt(2)]
                logger.debug("Enhance ($x,$y) by $enhanceIndex from ${get(x,y).value} to $enhancedPixel")
                enhanced.set(x,y,enhancedPixel)
            }
        }
        return enhanced
    }

    private fun getOrDefault(x: Int, y: Int) = getOrNull(x,y) ?.value ?: get(0,0).value

    fun litPixels(): Int = content.filter { it > 0 }.sum()

    override fun valueToString(value: Byte): String = if (value == 0.toByte()) "." else "#"
}