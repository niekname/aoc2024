package be.niekname.aoc2024

class Day5Part1(input: String) {
    private val rules = input.split("\n\n").first().lines().map { it.split("|") }
    private val updates = input.split("\n\n").last().lines().map { it.split(",") }

    fun correctlyOrderedUpdates() =
        updates.filter { it.isCorrect() }.sumOf { it[it.size / 2].toInt() }

    private fun List<String>.isCorrect(): Boolean {
        return rules.all { followsRule(this, it) }
    }

    private fun followsRule(update: List<String>, rule: List<String>): Boolean {
        val first = update.indexOf(rule.first())
        val last = update.indexOf(rule.last())
        return first == -1 || last == -1 || first < last
    }
}

