package be.niekname.aoc2024

fun main() {
    val input = Day4Part2::class.java.getResource("day4part2")!!.readText()
    val result = Day4Part2(input).findXmas()
    println("result = $result")
}