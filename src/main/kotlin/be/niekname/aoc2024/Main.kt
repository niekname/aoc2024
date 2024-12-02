package be.niekname.aoc2024

fun main() {
    val input = Part2().javaClass.getResource("day1part2")!!.readText()
    val result = Part2().similarityScore(input)
    println("result = $result")
}