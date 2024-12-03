package be.niekname.aoc2024

fun main() {
    val input = Day3Part1().javaClass.getResource("day3part1")!!.readText()
    val result = Day3Part1().fixCorruptedMemory(input)
    println("result = $result")
}