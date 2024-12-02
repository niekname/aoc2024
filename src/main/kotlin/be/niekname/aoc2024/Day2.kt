package be.niekname.aoc2024

import kotlin.math.abs

class Day2Part1 {
    fun numberOfSafeReports(input: String) =
        parseInput(input).count { it.isSafe() }
}

private fun parseInput(input: String) = input.lines().map { it.toReport() }

private fun String.toReport() =
    Report(this.split(" ").map { it.toInt() })

data class Report(val levels: List<Int>) {
    fun isSafe() =
        (allLevelsIncreasing() || allLevelsDecreasing())
                && notToFarApart()

    private fun allLevelsIncreasing() =
        levels.zipWithNext().all { (e1, e2) -> e1 < e2 }

    private fun allLevelsDecreasing() =
        levels.zipWithNext().all { (e1, e2) -> e1 > e2 }

    private fun notToFarApart() =
        levels.zipWithNext().all { (e1, e2) -> abs(e1 - e2) in (1..3) }
}