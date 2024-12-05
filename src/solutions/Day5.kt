package solutions

import Solver

class Day5(version: String) : Solver(5, version)
{
    private val orderingRules = mutableListOf<Pair<Int, Int>>()
    private var index = 0
    private var comparator: Comparator<String>

    init {
        do {
            val line = inputLines[index]
            val split = line.split("|")
            orderingRules.add(Pair(split[0].toInt(), split[1].toInt()))
            index++
        } while (inputLines[index] != "")
        comparator = PageComparator()
    }

    private inner class PageComparator: Comparator<String>{
        override fun compare(o1: String?, o2: String?): Int {
            for (rule in orderingRules) {
                if(rule.first == o1!!.toInt() && rule.second == o2!!.toInt()) {
                    return -1
                }
                if(rule.first == o2!!.toInt() && rule.second == o1.toInt()) {
                    return 1
                }
            }
            return 0
        }
    }

    override fun part1(): String
    {
        var result = 0

        index++

        while (index < inputLines.size)
        {
            val line = inputLines[index]

            val splitLine = line.split(",")
            val mapOfSplitValues = mutableMapOf<Int, Int>()
            for (i in splitLine.indices)
            {
                mapOfSplitValues[splitLine[i].toInt()] = i
            }

            var isValid = true
            for (rule in orderingRules)
            {
                if(mapOfSplitValues.contains(rule.first) && mapOfSplitValues.contains(rule.second))
                {
                    if(mapOfSplitValues[rule.first]!! > mapOfSplitValues[rule.second]!!)
                    {
                        isValid = false
                        break
                    }
                }
            }

            if(isValid)
            {
                result += splitLine[splitLine.size/2].toInt()
            }

            index++
        }

        return result.toString()
    }

    override fun part2(): String
    {
        var result = 0
        index++

        while (index < inputLines.size)
        {
            val line = inputLines[index]

            val splitLine = line.split(",")
            val mapOfSplitValues = mutableMapOf<Int, Int>()
            for (i in splitLine.indices)
            {
                mapOfSplitValues[splitLine[i].toInt()] = i
            }

            var isValid = true
            for (rule in orderingRules)
            {
                if(mapOfSplitValues.contains(rule.first) && mapOfSplitValues.contains(rule.second))
                {
                    if(mapOfSplitValues[rule.first]!! > mapOfSplitValues[rule.second]!!)
                    {
                        isValid = false
                        break
                    }
                }
            }

            if(!isValid)
            {
                val correctLine = fixLine(inputLines[index])
                result += correctLine[correctLine.size/2].toInt()
            }

            index++
        }

        return result.toString()
    }

    fun fixLine(line: String): List<String>
    {
        val splitLine = line.split(",").toMutableList()
        return splitLine.sortedWith(comparator)
    }

}