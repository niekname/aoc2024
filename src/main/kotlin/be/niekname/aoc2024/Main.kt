package be.niekname.aoc2024

fun main() {
    val input = Day2Part2().javaClass.getResource("day2part2")!!.readText()
    val result = Day2Part2().numberOfSafeReports(input)
    println("result = $result")
}