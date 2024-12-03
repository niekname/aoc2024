package be.niekname.aoc2024

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day3Test {

    val exampleInput = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"

    @Nested
    inner class Part1Test {
        @Test
        fun `fix memory`() {
            val result = Day3Part1().fixCorruptedMemory(exampleInput)
            assertThat(result).isEqualTo(161)
        }
    }

}