package net.codetreats.aoc2021.day19

import javafx.geometry.Pos

data class Orientation(val xRot: Int, val yRot: Int, val zRot: Int)

/*
enum class Orientation(val rotator: (pos: Position) -> Position) {
    X_POSITIVE_0_DEGREE({ it }),
    X_POSITIVE_90_DEGREE({it.rotateX0()}),
    X_POSITIVE_180_DEGREE({
        Position(it.x, -it.y, it.z)
    }),
    X_POSITIVE_270_DEGREE({
        Position(it.x, it.z, -it.y)
    }),
    X_NEGATIVE_0_DEGREE({
        Position(-it.x, it.y, -it.z)
    }),
    X_NEGATIVE_90_DEGREE({
        Position(-it.x, it.y, -it.z)
    }),
    X_NEGATIVE_180_DEGREE({
        Position(-it.x, it.y, -it.z)
    }),
    X_NEGATIVE_270_DEGREE({
        Position(-it.x, it.y, -it.z)
    }),
//    Y_POSITIVE_0_DEGREE,
//    Y_POSITIVE_90_DEGREE,
//    Y_POSITIVE_180_DEGREE,
//    Y_POSITIVE_270_DEGREE,
//    Y_NEGATIVE_0_DEGREE,
//    Y_NEGATIVE_90_DEGREE,
//    Y_NEGATIVE_180_DEGREE,
//    Y_NEGATIVE_270_DEGREE,
//    Z_POSITIVE_0_DEGREE,
//    Z_POSITIVE_90_DEGREE,
//    Z_POSITIVE_180_DEGREE,
//    Z_POSITIVE_270_DEGREE,
//    Z_NEGATIVE_0_DEGREE,
//    Z_NEGATIVE_90_DEGREE,
//    Z_NEGATIVE_180_DEGREE,
//    Z_NEGATIVE_270_DEGREE
}*/