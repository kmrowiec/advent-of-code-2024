import java.io.FileReader

fun readInputFile(day: Int, version: String): List<String>
{
    return FileReader("input/${day}/${version}.txt").readLines()
}

abstract class Solver(day: Int, version: String) {

    var inputLines = readInputFile(day, version)

    abstract fun part1(): String
    abstract fun part2(): String
}

class Grid(private var input: List<String>)
{
    fun get(x: Int, y: Int): Char? {
        if(x >= 0 && x < input[0].length && y >=0 && y < input.size) {
            return input[y][x]
        }
        return null
    }
}