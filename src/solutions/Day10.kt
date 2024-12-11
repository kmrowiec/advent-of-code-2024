package solutions

import Grid
import Solver

class Day10(version: String) : Solver(10, version)
{
    private val grid = Grid(inputLines.toMutableList())

    override fun part1(): String
    {
        var result = 0

        val iterator = grid.iterator()
        while (iterator.hasNext())
        {
            val gridEntry = iterator.next()
            if(gridEntry.value == '0') {
                result += countTrails(gridEntry)
            }
        }
        return result.toString()
    }

    private fun countTrails(start: Grid.GridEntry) : Int
    {
        val currentRoute = mutableListOf(start)
        val foundPeaks = mutableSetOf<Grid.Point>()

        while (currentRoute.isNotEmpty())
        {
            val lastElement = currentRoute.removeAt(currentRoute.size - 1)
            val neighbours = grid.getNWSE(lastElement.point)
            for (neighbour in neighbours) {
                if (neighbour.value.toString().toInt() == lastElement.value.toString().toInt() + 1)
                {
                    if(neighbour.value == '9') {
                        foundPeaks.add(neighbour.point)
                    } else {
                        currentRoute.add(neighbour)
                    }
                }
            }
        }
        return foundPeaks.size
    }

    override fun part2(): String
    {
        var result = 0
        val iterator = grid.iterator()
        while (iterator.hasNext())
        {
            val gridEntry = iterator.next()
            if(gridEntry.value == '0') {
                result += rateTrailhead(gridEntry)
            }
        }
        return result.toString()
    }

    private fun rateTrailhead(start: Grid.GridEntry) : Int
    {
        val currentRoute = mutableListOf(start)
        var foundPeaks = 0

        while (currentRoute.isNotEmpty())
        {
            val lastElement = currentRoute.removeAt(currentRoute.size - 1)
            val neighbours = grid.getNWSE(lastElement.point)
            for (neighbour in neighbours) {
                if (neighbour.value.toString().toInt() == lastElement.value.toString().toInt() + 1)
                {
                    if(neighbour.value == '9') {
                        foundPeaks++
                    } else {
                        currentRoute.add(neighbour)
                    }
                }
            }
        }
        return foundPeaks
    }
}