package solutions

import Solver

class Day11(version: String) : Solver(11, version)
{
    private var stones = inputLines[0].split(" ")
    private var cache = mutableMapOf<Pair<String, Int>, Long>()

    override fun part1(): String
    {
        return solve(25)
    }

    override fun part2(): String
    {
        return solve(75)
    }

    fun solve(iterations: Int): String {

        var result = 0L
        for (stone in stones)
        {
            result += solveForSingleStone(stone, iterations)
        }
        return result.toString()
    }

    private fun solveForSingleStone(stone: String, iterations: Int): Long {
        return if(iterations == 0) {
            1
        } else {
            if (stone.length % 2 == 0) {
                solveForSingleStone(stone.substring(0, stone.length / 2), iterations -1) +
                        solveForSingleStone(stone.substring(stone.length / 2, stone.length).toLong().toString(), iterations-1)
            } else if (stone.length == 1) {
                solveForSingleCharacter(stone, iterations)
            } else {
                solveForSingleStone((stone.toLong() * 2024).toString(), iterations-1)
            }
        }
    }

    private fun solveForSingleCharacter(stone: String, iterations: Int): Long {

        if(iterations == 0) {
            return 1
        }
        else if (cache.contains(Pair(stone, iterations))) {
            return cache[Pair(stone, iterations)]!!
        }
        else {
            if(stone == "0")
            {
                return solveForSingleStone("1", iterations-1)
            }
            else {
                val solution = solveForSingleStone((stone.toLong() * 2024).toString(), iterations-1)
                cache[Pair(stone, iterations)] = solution
                return solution
            }
        }
    }
}