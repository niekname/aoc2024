package be.niekname.aoc2024

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day1Test {

    val exampleInput = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3""".trimIndent()

    @Nested
    inner class Part1Test {
        @Test
        fun `total distance between lists`() {
            val result = Day1Part1().totalDistanceBetweenLists(exampleInput)
            assertThat(result).isEqualTo(11)
        }
    }

    @Nested
    inner class Part2Test {
        @Test
        fun `similarity score`() {
            val result = Day1Part2().similarityScore(exampleInput)
            assertThat(result).isEqualTo(31)
        }
    }

}