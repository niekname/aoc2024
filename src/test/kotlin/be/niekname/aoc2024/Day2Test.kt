package be.niekname.aoc2024

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day2Test {

    val exampleInput = """
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9""".trimIndent()

    @Nested
    inner class Part1Test {
        @Test
        fun `number of safe reports`() {
            val result = Day2Part1().numberOfSafeReports(exampleInput)
            assertThat(result).isEqualTo(2)
        }
    }

}