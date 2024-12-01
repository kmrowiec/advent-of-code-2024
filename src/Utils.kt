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