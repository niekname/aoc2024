package be.niekname.aoc2024

import kotlin.math.abs

class Day1Part1 {
    fun totalDistanceBetweenLists(input: String): Int {
        val (left, right) = parseInput(input)
        val leftSorted = left.sorted()
        val rightSorted = right.sorted()

        return leftSorted
            .mapIndexed { idx, it -> abs(it - rightSorted[idx]) }
            .sum()
    }
}

class Day1Part2 {
    fun similarityScore(input: String): Int {
        val (left, right) = parseInput(input)
        return left.sumOf { leftElement -> leftElement * right.count { it == leftElement } }
    }
}

private fun parseInput(input: String) = input.lines().map { line ->
    val (left, right) = line.split("\\s+".toRegex()).map { it.toInt() }
    left to right
}.unzip()
