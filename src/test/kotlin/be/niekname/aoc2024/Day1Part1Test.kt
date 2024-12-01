package be.niekname.aoc2024

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day1Part1Test {

    @Test
    fun `total distance between lists`() {
        val input = """3   4
4   3
2   5
1   3
3   9
3   3"""

        val result = Day1Part1().totalDistanceBetweenLists(input)

        assertThat(result).isEqualTo(11)
    }
}