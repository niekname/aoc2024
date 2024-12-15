package be.niekname.aoc2024

fun main() {
    val input = Day5Part2::class.java.getResource("day5part2")!!.readText()
    val result = Day5Part2(input).correctlyOrderedUpdates()
    println("result = $result")
}