package solutions

import Grid
import Solver

class Day6(version: String) : Solver(6, version)
{
    private var grid = Grid(inputLines.toMutableList())

    override fun part1(): String
    {
        val start = grid.find('^')
        println("Starting at ${start?.x}, ${start?.y}")

        var cX = start!!.x
        var cY = start.y
        var cDir = "UP"
        while (grid.get(cX, cY) != null)
        {
            grid.set(cX, cY, 'X')
            if (cDir == "UP")
            {
                if(grid.get(cX, cY-1) == '#') {
                    cDir = "RIGHT"
                    continue
                }
                cY--
            }
            else if (cDir == "DOWN")
            {
                if(grid.get(cX, cY+1) == '#') {
                    cDir = "LEFT"
                    continue
                }
                cY++
            }
            else if (cDir == "LEFT")
            {
                if(grid.get(cX-1, cY) == '#') {
                    cDir = "UP"
                    continue
                }
                cX--
            }
            else //if (cDir == "RIGHT")
            {
                if(grid.get(cX+1, cY) == '#') {
                    cDir = "DOWN"
                    continue
                }
                cX++
            }
        }

        grid.print()

        return grid.count('X').toString()
    }

    override fun part2(): String
    {
        var result = 0;

        for(y in inputLines.indices)
        {
            for (x in inputLines[0].indices)
            {
                println("Inserting at ${x}, ${y}")
                grid = Grid(inputLines.toMutableList())

                if(grid.get(x, y) == '#' || grid.get(x, y) == '^') {
                    continue
                }

                grid.set(x, y, '#')

                val start = grid.find('^')

                var cX = start!!.x
                var cY = start.y
                var cDir = "UP"
                val encounterMap = mutableMapOf<String, Int>()

                while (grid.get(cX, cY) != null)
                {
                    grid.set(cX, cY, 'X')
                    if (cDir == "UP")
                    {
                        if(grid.get(cX, cY-1) == '#') {
                            encounterMap.putIfAbsent("${cX}${cY}${cDir}", 1)
                            val count = encounterMap.get("${cX}${cY}${cDir}")!!
                            if (count > 5) {
                                println("Solution found: ${x}, ${y}")
                                result++
                                break
                            } else {
                                encounterMap.put("${cX}${cY}${cDir}", count + 1)
                            }
                            cDir = "RIGHT"
                            continue
                        }
                        cY--
                    }
                    else if (cDir == "DOWN")
                    {
                        if(grid.get(cX, cY+1) == '#') {
                            encounterMap.putIfAbsent("${cX}${cY}${cDir}", 1)
                            val count = encounterMap.get("${cX}${cY}${cDir}")!!
                            if (count > 5) {
                                println("Solution found: ${x}, ${y}")
                                result++
                                break
                            } else {
                                encounterMap.put("${cX}${cY}${cDir}", count + 1)
                            }
                            cDir = "LEFT"
                            continue
                        }
                        cY++
                    }
                    else if (cDir == "LEFT")
                    {
                        if(grid.get(cX-1, cY) == '#') {
                            encounterMap.putIfAbsent("${cX}${cY}${cDir}", 1)
                            val count = encounterMap.get("${cX}${cY}${cDir}")!!
                            if (count > 5) {
                                println("Solution found: ${x}, ${y}")
                                result++
                                break
                            } else {
                                encounterMap.put("${cX}${cY}${cDir}", count + 1)
                            }
                            cDir = "UP"
                            continue
                        }
                        cX--
                    }
                    else //if (cDir == "RIGHT")
                    {
                        if(grid.get(cX+1, cY) == '#') {
                            encounterMap.putIfAbsent("${cX}${cY}${cDir}", 1)
                            val count = encounterMap.get("${cX}${cY}${cDir}")!!
                            if (count > 5) {
                                println("Solution found: ${x}, ${y}")
                                result++
                                break
                            } else {
                                encounterMap.put("${cX}${cY}${cDir}", count + 1)
                            }
                            cDir = "DOWN"
                            continue
                        }
                        cX++
                    }
                }
            }
        }

        return result.toString()
    }
}