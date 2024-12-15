package be.niekname.aoc2024

class Day5Part1(input: String) {
    private val rules = input.split("\n\n").first().lines()
        .map { it.split("|") }
        .map { Rule(it.first().toInt(), it.last().toInt()) }

    private val updates = input.split("\n\n").last().lines()
        .map { it.split(",") }
        .map { Update(it.map { pn -> pn.toInt() }) }

    fun correctlyOrderedUpdates() =
        updates.filter { it.followsRules(rules) }.sumOf { it.middleItem() }

}

class Day5Part2(input: String) {
    private val rules = input.split("\n\n").first().lines()
        .map { it.split("|") }
        .map { Rule(it.first().toInt(), it.last().toInt()) }
    private val updates = input.split("\n\n").last().lines()
        .map { it.split(",") }
        .map { Update(it.map { pn -> pn.toInt() }) }

    fun correctlyOrderedUpdates() =
        updates.filterNot { it.followsRules(rules) }
            .map { it.applyRules(rules) }
            .sumOf { it.middleItem() }

}

data class Rule(val left: Int, val right: Int)

class Update(pageNumbers: List<Int>) {
    private val _pageNumbers = pageNumbers.toMutableList()

    fun middleItem() = _pageNumbers[_pageNumbers.size / 2]

    fun followsRules(rules: List<Rule>) =
        rules.all { followsRule(it) }

    private fun followsRule(rule: Rule): Boolean {
        return when {
            _pageNumbers.contains(rule.left) && _pageNumbers.contains(rule.right) -> {
                _pageNumbers.indexOf(rule.left) < _pageNumbers.indexOf(rule.right)
            }

            else -> true
        }
    }

    fun applyRules(rules: List<Rule>): Update {
        while (!followsRules(rules)) {
            rules.forEach { applyRule(it) }
        }
        return Update(_pageNumbers)
    }

    private fun applyRule(rule: Rule) {
        if (followsRule(rule)) return
        _pageNumbers.removeAt(_pageNumbers.indexOf(rule.left))
        _pageNumbers.add(_pageNumbers.indexOf(rule.right), rule.left)
    }
}