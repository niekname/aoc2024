package be.niekname.aoc2024

fun main() {
    val input = Day5Part1::class.java.getResource("day5part1")!!.readText()
    val result = Day5Part1(input).correctlyOrderedUpdates()
    println("result = $result")
}