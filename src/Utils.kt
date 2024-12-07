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

class Grid(private var input: MutableList<String>)
{
    fun get(x: Int, y: Int): Char? {
        if(x >= 0 && x < input[0].length && y >=0 && y < input.size) {
            return input[y][x]
        }
        return null
    }

    fun set(x: Int, y: Int, c: Char)
    {
        val chars = input[y].toMutableList()
        chars[x] = c
        input[y] = chars.joinToString(separator = "")
    }

    fun find(c: Char): Point? {
        for (y in input.indices)
        {
            for (x in input[y].indices)
            {
                if(input[y][x] == c) {
                    return Point(x, y)
                }
            }
        }
        return null
    }

    fun count(c: Char): Int {
        var result = 0
        for (y in input.indices)
        {
            for (x in input[y].indices)
            {
                if(input[y][x] == c) {
                    result++
                }
            }
        }
        return result
    }

    fun print()
    {
        for (y in input.indices)
        {
            println(input[y])
        }
    }

    class Point(var x: Int, var y: Int)
}