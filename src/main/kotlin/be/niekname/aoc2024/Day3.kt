package be.niekname.aoc2024

class Day3Part1 {
    fun fixCorruptedMemory(input: String): Int {
        val regex = "mul\\(\\d{1,3},\\d{1,3}\\)".toRegex()
        return regex.findAll(input)
            .sumOf { doMultiply(it.value) }
    }

    private fun doMultiply(mul: String) =
        mul.removePrefix("mul(")
            .removeSuffix(")")
            .split(",")
            .map(String::toInt)
            .reduce { left, right -> left * right }
}
