package solutions

import Solver
import kotlin.math.abs

class Day1(version: String) : Solver(1, version)
{
    private var list1 = mutableListOf<Int>()
    private var list2 = mutableListOf<Int>()

    init {
        for (line in inputLines)
        {
            val split = line.split("   ")
            list1.add(split[0].toInt())
            list2.add(split[1].toInt())
        }
    }

    override fun part1(): String
    {
        val sortedList1 = list1.sorted()
        val sortedList2 = list2.sorted()

        var result = 0
        for(index in list1.indices)
        {
            result += abs(sortedList1[index] - sortedList2[index])
        }
        return result.toString()
    }

    override fun part2(): String
    {
        val groupedList2 = mutableMapOf<Int, Int>()

        for (number in list2)
        {
            if (groupedList2.containsKey(number)) {
                groupedList2[number] = groupedList2[number]!! + 1
            } else {
                groupedList2[number] = 1
            }
        }

        var result = 0

        for (number in list1)
        {
            if (groupedList2.containsKey(number))
            {
                result += number * groupedList2[number]!!
            }
        }

        return result.toString()
    }

}