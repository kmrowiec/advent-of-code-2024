package solutions

import Solver

class Day7(version: String) : Solver(7, version)
{
    private val add = { a: Long, b: Long -> a + b}
    private val multiply = { a: Long, b: Long -> a * b}
    private val concat = { a: Long, b: Long -> (a.toString() + b.toString()).toLong()}

    override fun part1(): String
    {
        return solve(listOf(add, multiply))
    }

    override fun part2(): String
    {
        return solve(listOf(add, multiply, concat))
    }

    private fun solve(operators: List<(Long, Long) -> Long>): String
    {
        var result = 0L
        for (line in inputLines)
        {
            val testAndRest = line.split(": ")
            val testAmount = testAndRest[0].toLong()
            val numbers = testAndRest[1].split(" ").map { x -> x.toLong() }.toList()
            var totals = mutableListOf(numbers[0])

            for (n in numbers.subList(1, numbers.size)) {
                val newTotals = mutableListOf<Long>()
                for (total in totals) {
                    for (op in operators) {
                        val invoke = op.invoke(total, n)
                        if (invoke <= testAmount) {
                            newTotals.add(invoke)
                        }
                    }
                }
                totals = newTotals
            }
            if (totals.contains(testAmount)) {
                result += testAmount
            }
        }
        return result.toString()
    }
}