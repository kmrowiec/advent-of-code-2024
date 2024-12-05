package solutions

import Solver
import kotlin.math.abs

class Day2(version: String) : Solver(2, version)
{

    override fun part1(): String
    {
        var result = 0
        for (line in inputLines)
        {
            if (validateLevel(line.split(" "))) {
                result++
            }
        }
        return result.toString()
    }

    override fun part2(): String
    {
        var result = 0
        for (line in inputLines)
        {
            val split = line.split(" ")

            if (validateLevel(split)) {
                result++
            }
            else
            {
                for (i in split.indices)
                {
                    val currentSplit = split.toMutableList()
                    currentSplit.removeAt(i)
                    if (validateLevel(currentSplit)) {
                        result++
                        break
                    }
                }
            }
        }
        return result.toString()
    }

    private fun validateLevel(split: List<String>): Boolean {
        var previous: Int
        var current = 0
        val increasing = split[0].toInt() < split[1].toInt()

        for (level in split) {
            previous = current
            current = level.toInt()
            if (previous > 0 && current > 0) {
                val correctDirection = current > previous == increasing
                val correctDifference = abs(current - previous) in 1..3
                if (!correctDifference || !correctDirection) {
                    return false
                }
            }
        }
        return true
    }
}