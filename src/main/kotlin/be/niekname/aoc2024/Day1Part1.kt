package be.niekname.aoc2024

import kotlin.math.abs

class Day1Part1 {
    fun totalDistanceBetweenLists(input: String): Int {
        val (left, right) = input.lines().map { line ->
            val (left, right) = line.split("\\s+".toRegex()).map { it.toInt() }
            left to right
        }.unzip()

        val leftSorted = left.sorted()
        val rightSorted = right.sorted()

        return leftSorted
            .mapIndexed { idx, it -> abs(it - rightSorted[idx]) }
            .sum()
    }
}