package be.niekname.aoc2024

class Day4Part1(input: String) {

    private val wordToFind = "XMAS"
    private val grid = Grid(input.lines().map { it.toCharArray() })

    fun findXmas() =
        grid.findAll('X')
            .sumOf { countXmasWord(it) }

    private fun countXmasWord(posOfX: Position) =
        listOf(
            grid.allCharsRightOf(posOfX),
            grid.allCharsLeftOf(posOfX),
            grid.allCharsUpOf(posOfX),
            grid.allCharsDownOf(posOfX),
            grid.allCharsRightDown(posOfX),
            grid.allCharsLeftDown(posOfX),
            grid.allCharsLeftUp(posOfX),
            grid.allCharsRightUp(posOfX),
        ).map { it.joinToString(separator = "") }
            .count { it.startsWith(wordToFind) }

    data class Grid(val rows: List<CharArray>) {
        private val numberOfRows get() = rows.size - 1
        private val numberOfCols get() = rows.first().size - 1

        fun findAll(char: Char) =
            rows.flatMapIndexed { rowIdx, row ->
                row.indices.filter { row[it] == char }
                    .map { Position(rowIdx, it) }
            }

        fun allCharsRightOf(pos: Position) =
            (pos.y..numberOfCols)
                .map { rows[pos.x][it] }

        fun allCharsLeftOf(pos: Position) =
            (0..pos.y).reversed()
                .map { rows[pos.x][it] }

        fun allCharsUpOf(pos: Position) =
            (0..pos.x).reversed()
                .map { rows[it][pos.y] }

        fun allCharsDownOf(pos: Position) =
            (pos.x..numberOfRows)
                .map { rows[it][pos.y] }

        fun allCharsRightDown(pos: Position) =
            (pos.x..numberOfRows)
                .zip(pos.y..numberOfCols)
                .map { rows[it.first][it.second] }

        fun allCharsLeftDown(pos: Position) =
            (pos.x..numberOfRows)
                .zip((0..pos.y).reversed())
                .map { rows[it.first][it.second] }

        fun allCharsLeftUp(pos: Position) =
            ((0..pos.x).reversed())
                .zip((0..pos.y).reversed())
                .map { rows[it.first][it.second] }

        fun allCharsRightUp(pos: Position) =
            ((0..pos.x).reversed())
                .zip(pos.y..numberOfCols)
                .map { rows[it.first][it.second] }
    }

    data class Position(val x: Int, val y: Int)
}