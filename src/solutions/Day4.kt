package solutions

import Grid
import Solver

class Day4(version: String) : Solver(4, version)
{
    override fun part1(): String
    {
        var result = 0
        val grid = Grid(inputLines)
        for (y in inputLines.indices)
        {
            for (x in inputLines[y].indices)
            {
                if(grid.get(x, y) == 'X')
                {
                    // Start counting from here
                    if("X" + grid.get(x, y+1) + grid.get(x, y+2) + grid.get(x, y+3) == "XMAS")
                    {
                        result++
                    }
                    if("X" + grid.get(x+1, y) + grid.get(x+2, y) + grid.get(x+3, y) == "XMAS")
                    {
                        result++
                    }

                    if("X" + grid.get(x, y-1) + grid.get(x, y-2) + grid.get(x, y-3) == "XMAS")
                    {
                        result++
                    }
                    if("X" + grid.get(x-1, y) + grid.get(x-2, y) + grid.get(x-3, y) == "XMAS")
                    {
                        result++
                    }

                    if("X" + grid.get(x+1, y+1) + grid.get(x+2, y+2) + grid.get(x+3, y+3) == "XMAS")
                    {
                        result++
                    }
                    if("X" + grid.get(x-1, y-1) + grid.get(x-2, y-2) + grid.get(x-3, y-3) == "XMAS")
                    {
                        result++
                    }

                    if("X" + grid.get(x+1, y-1) + grid.get(x+2, y-2) + grid.get(x+3, y-3) == "XMAS")
                    {
                        result++
                    }
                    if("X" + grid.get(x-1, y+1) + grid.get(x-2, y+2) + grid.get(x-3, y+3) == "XMAS")
                    {
                        result++
                    }
                }
            }
        }
        return result.toString()
    }

    override fun part2(): String
    {
        var result = 0
        val grid = Grid(inputLines)
        for (y in inputLines.indices)
        {
            for (x in inputLines[y].indices)
            {


                if(grid.get(x, y) == 'A')
                {
                    // Start counting from here
                    if(("" + grid.get(x-1, y-1) + 'A' + grid.get(x+1, y+1)  == "MAS") ||
                        "" + grid.get(x-1, y-1) + 'A' + grid.get(x+1, y+1)  == "SAM")
                    {
                        if(("" + grid.get(x+1, y-1) + 'A' + grid.get(x-1, y+1)  == "MAS") ||
                            "" + grid.get(x+1, y-1) + 'A' + grid.get(x-1, y+1)  == "SAM")
                        {
                            result++
                        }
                    }
                }
            }
        }
        return result.toString()
    }

}