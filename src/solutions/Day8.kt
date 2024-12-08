package solutions

import Grid
import Solver

class Day8(version: String) : Solver(8, version)
{
    override fun part1(): String
    {
        val grid = Grid(inputLines.toMutableList())

        for (entry in readAntennas(grid).entries)
        {
            val combinations = mutableListOf<Pair<Grid.Point, Grid.Point>>()
            for (i in entry.value.indices) {
                for (j in entry.value.indices) {
                    if(j > i) {
                        combinations.add(Pair(entry.value[i], entry.value[j]))
                    }
                }
            }
            for(value in combinations)
            {
                val x1 = value.first.x - (value.second.x - value.first.x)
                val y1 = value.first.y - (value.second.y - value.first.y)

                val x2 = value.second.x - (value.first.x - value.second.x)
                val y2 = value.second.y - (value.first.y - value.second.y)

                grid.set(x1, y1, '#')
                grid.set(x2, y2, '#')
            }
        }

        grid.print()

        return grid.count('#').toString()
    }

    private fun readAntennas(grid: Grid): MutableMap<Char, MutableList<Grid.Point>>
    {
        val antennasMap = mutableMapOf<Char, MutableList<Grid.Point>>()
        val iterator = grid.iterator()
        while (iterator.hasNext()) {
            val gridEntry = iterator.next()
            if (gridEntry.value != '.') {
                antennasMap.putIfAbsent(gridEntry.value, mutableListOf())
                antennasMap[gridEntry.value]!!.add(gridEntry.point)
            }
        }
        return antennasMap
    }

    override fun part2(): String
    {
        val grid = Grid(inputLines.toMutableList())

        for (entry in readAntennas(grid).entries)
        {
            val combinations = mutableListOf<Pair<Grid.Point, Grid.Point>>()
            for (i in entry.value.indices) {
                for (j in entry.value.indices) {
                    if(j > i) {
                        combinations.add(Pair(entry.value[i], entry.value[j]))
                    }
                }
            }
            for(value in combinations)
            {
                val x1Diff = (value.second.x - value.first.x)
                val y1Diff = value.second.y - value.first.y
                val x2Diff = value.first.x - value.second.x
                val y2Diff = value.first.y - value.second.y

                var i = 1
                do {
                    val x1 = value.first.x - i * x1Diff
                    val y1 = value.first.y - i * y1Diff
                    grid.set(x1, y1, '#')
                    i++
                } while (grid.get(value.first.x - i * x1Diff, value.first.y - i * y1Diff) != null)

                i = 1
                do {
                    val x1 = value.second.x - i * x2Diff
                    val y1 = value.second.y - i * y2Diff
                    grid.set(x1, y1, '#')
                    i++
                } while (grid.get(value.second.x - i * x2Diff, value.second.y - i * y2Diff) != null)

                grid.set(value.first.x, value.first.y, '#')
                grid.set(value.second.x, value.second.y, '#')
            }
        }

        grid.print()

        return grid.count('#').toString()
    }
}