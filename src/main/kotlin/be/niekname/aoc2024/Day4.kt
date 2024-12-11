package be.niekname.aoc2024

class Day4Part1(input: String) {
    private val wordToFind = "XMAS"
    private val grid = Grid(input.lines().map { it.toCharArray() })

    fun findXmas() = grid.findAll('X').sumOf { countXmasWord(it) }

    private fun countXmasWord(pos: Position) =
        listOf(
            grid.allCharsRightOf(pos),
            grid.allCharsLeftOf(pos),
            grid.allCharsUpOf(pos),
            grid.allCharsDownOf(pos),
            grid.allCharsRightDown(pos),
            grid.allCharsLeftDown(pos),
            grid.allCharsLeftUp(pos),
            grid.allCharsRightUp(pos),
        ).map { it.joinToString(separator = "", prefix = "X") }
            .count { it.startsWith(wordToFind) }
}

class Day4Part2(input: String) {
    private val grid = Grid(input.lines().map { it.toCharArray() })

    fun findXmas() = grid.findAll('A').sumOf { countXmas(it) }

    private fun countXmas(pos: Position): Int {
        val a = "${grid.allCharsLeftUp(pos).firstOrNull()}A${grid.allCharsRightDown(pos).firstOrNull()}"
        val b = "${grid.allCharsRightUp(pos).firstOrNull()}A${grid.allCharsLeftDown(pos).firstOrNull()}"
        return if ((a == "MAS" || a.reversed() == "MAS")
            && (b == "MAS" || b.reversed() == "MAS")
        ) 1 else 0
    }
}


data class Grid(val rows: List<CharArray>) {
    private val numberOfRows get() = rows.size - 1
    private val numberOfCols get() = rows.first().size - 1

    fun findAll(char: Char) =
        rows.flatMapIndexed { rowIdx, row ->
            row.indices.filter { row[it] == char }
                .map { Position(rowIdx, it) }
        }

    fun allCharsRightOf(pos: Position) =
        (pos.y + 1..numberOfCols)
            .map { rows[pos.x][it] }

    fun allCharsLeftOf(pos: Position) =
        (0..<pos.y).reversed()
            .map { rows[pos.x][it] }

    fun allCharsUpOf(pos: Position) =
        (0..<pos.x).reversed()
            .map { rows[it][pos.y] }

    fun allCharsDownOf(pos: Position) =
        (pos.x + 1..numberOfRows)
            .map { rows[it][pos.y] }

    fun allCharsRightDown(pos: Position) =
        (pos.x + 1..numberOfRows)
            .zip(pos.y + 1..numberOfCols)
            .map { rows[it.first][it.second] }

    fun allCharsLeftDown(pos: Position) =
        (pos.x + 1..numberOfRows)
            .zip((0..<pos.y).reversed())
            .map { rows[it.first][it.second] }

    fun allCharsLeftUp(pos: Position) =
        ((0..<pos.x).reversed())
            .zip((0..<pos.y).reversed())
            .map { rows[it.first][it.second] }

    fun allCharsRightUp(pos: Position) =
        ((0..<pos.x).reversed())
            .zip(pos.y + 1..numberOfCols)
            .map { rows[it.first][it.second] }
}

data class Position(val x: Int, val y: Int)
