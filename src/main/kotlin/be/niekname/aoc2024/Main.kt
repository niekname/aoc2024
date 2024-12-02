package be.niekname.aoc2024

fun main() {
    val input = Day2Part1().javaClass.getResource("day2part1")!!.readText()
    val result = Day2Part1().numberOfSafeReports(input)
    println("result = $result")
}