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
        if(x >= 0 && x < input[0].length && y >=0 && y < input.size)
        {
            val chars = input[y].toMutableList()
            chars[x] = c
            input[y] = chars.joinToString(separator = "")
        }
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

    fun iterator(): Iterator<GridEntry>
    {
        return object : Iterator<GridEntry>
        {
            var cY = 0
            var cX = 0

            override fun hasNext(): Boolean
            {
                return !(cY >= input.size-1 && cX >= input[0].length-1)
            }

            override fun next(): GridEntry {
                val result = GridEntry(get(cX, cY)!!, Point(cX, cY))
                if(cX == input[0].length - 1) {
                    cY ++
                    cX = 0
                } else {
                    cX ++
                }
                return result
            }

        }
    }

    class Point(var x: Int, var y: Int)
    {
        override fun toString(): String{
            return "($x,$y)"
        }
    }

    class GridEntry(var value: Char, var point: Point)
    {
        override fun toString(): String{
            return "$value (${point.x},${point.y})"
        }
    }
}