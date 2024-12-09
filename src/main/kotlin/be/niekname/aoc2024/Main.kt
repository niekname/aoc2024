package be.niekname.aoc2024

fun main() {
    val input = Day4Part1::class.java.getResource("day4part1")!!.readText()
    val result = Day4Part1(input).findXmas()
    println("result = $result")
}