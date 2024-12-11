package be.niekname.aoc2024

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day4Test {
    private val exampleInput = """
        MMMSXXMASM
        MSAMXMSMSA
        AMXSXMAAMM
        MSAMASMSMX
        XMASAMXAMM
        XXAMMXXAMA
        SMSMSASXSS
        SAXAMASAAA
        MAMMMXMMMM
        MXMXAXMASX
    """.trimIndent()

    @Nested
    inner class Part1Test {
        @Test
        fun `find XMAS`() {
            val result = Day4Part1(exampleInput).findXmas()
            assertThat(result).isEqualTo(18)
        }
    }

    @Nested
    inner class Part2Test {
        @Test
        fun `find XMAS`() {
            val result = Day4Part2(exampleInput).findXmas()
            assertThat(result).isEqualTo(9)
        }
    }
}