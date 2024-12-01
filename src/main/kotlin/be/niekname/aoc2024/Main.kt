package be.niekname.aoc2024

fun main() {
    val input = Day1Part1().javaClass.getResource("day1part1")!!.readText()
    val result = Day1Part1().totalDistanceBetweenLists(input)
    println("result = $result")
}