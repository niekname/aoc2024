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

class Day3Part2 {
    fun fixCorruptedMemory(input: String): Int {
        val regex = "mul\\(\\d{1,3},\\d{1,3}\\)|don't\\(\\)|do\\(\\)".toRegex()
        val instructions = regex.findAll(input).map { it.value }

        var mulEnabled = true
        var result = 0
        instructions.forEach {
            if (it == "do()") mulEnabled = true
            else if (it == "don't()") mulEnabled = false
            else if (mulEnabled) result += doMultiply(it)
        }

        return result
    }

    private fun doMultiply(mul: String) =
        mul.removePrefix("mul(")
            .removeSuffix(")")
            .split(",")
            .map(String::toInt)
            .reduce { left, right -> left * right }
}
