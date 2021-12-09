package net.codetreats.aoc2021.common;

data class DataPoint<T>(override val x: Int, override val y: Int, val value: T) : Point

typealias IntPoint = DataPoint<Int>