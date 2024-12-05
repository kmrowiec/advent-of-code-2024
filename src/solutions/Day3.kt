package solutions

import Solver

class Day3(version: String) : Solver(3, version)
{
    override fun part1(): String
    {
        var result = 0
        for (line in inputLines)
        {
            result += parseLine(line)
        }
        return result.toString()
    }

    fun parseLine(line: String): Int
    {
        var result = 0
        val buffer = StringBuilder()
        var activeCommand = false
        val numbers = listOf<Int>().toMutableList()

        for (currentChar in line)
        {
            if (activeCommand)
            {
                // if not valid input, clean up
                if(!charArrayOf(',', ')', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9').contains(currentChar)) {
                    activeCommand = false
                    buffer.clear()
                    numbers.clear()
                    buffer.append(currentChar)
                }
                else
                {
                    if (currentChar == ',') {
                        if (numbers.isEmpty() && buffer.length in 1..3) {
                            numbers.add(buffer.toString().toInt())
                            buffer.clear()
                        } else {
                            activeCommand = false
                            buffer.clear()
                            numbers.clear()
                        }
                    }
                    else if (currentChar == ')') {
                        if (numbers.size == 1 && buffer.length in 1..3) {
                            numbers.add(buffer.toString().toInt())
                            buffer.clear()
                        } else {
                            buffer.clear()
                            numbers.clear()
                        }
                        activeCommand = false
                    }
                    else {
                        buffer.append(currentChar.toString())
                    }

                    if(numbers.size == 2) {
                        result += numbers[0] * numbers[1]
                        activeCommand = false
                        buffer.clear()
                        numbers.clear()
                    }
                }
            }
            else if (buffer.endsWith("mul(")) {
                activeCommand = true
                buffer.clear()
                numbers.clear()
                buffer.append(currentChar)
            } else {
                buffer.append(currentChar)
            }
        }
        return result
    }

    override fun part2(): String
    {
        var result = 0
        var enableCommand = true

        for (line in inputLines)
        {
            val buffer = StringBuilder()
            var activeCommand = false
            val numbers = listOf<Int>().toMutableList()

            for (i in line.indices)
            {
                if (activeCommand)
                {
                    // if not valid input, clean up
                    if(!charArrayOf(',', ')', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9').contains(line[i])) {
                        activeCommand = false
                        buffer.clear()
                        numbers.clear()
                        buffer.append(line[i])
                    }
                    else
                    {
                        if (line[i] == ',') {
                            if (numbers.isEmpty() && buffer.length in 1..3) {
                                numbers.add(buffer.toString().toInt())
                                buffer.clear()
                            } else {
                                activeCommand = false
                                buffer.clear()
                                numbers.clear()
                            }
                        }
                        else if (line[i] == ')') {
                            if (numbers.size == 1 && buffer.length in 1..3) {
                                numbers.add(buffer.toString().toInt())
                                buffer.clear()
                            } else {
                                buffer.clear()
                                numbers.clear()
                            }
                            activeCommand = false
                        }
                        else {
                            buffer.append(line[i].toString())
                        }

                        if(numbers.size == 2) {
                            if(enableCommand){
                                result += numbers[0] * numbers[1]
                            }
                            activeCommand = false
                            buffer.clear()
                            numbers.clear()
                        }
                    }
                }
                else if (buffer.endsWith("mul(")) {
                    activeCommand = true
                    buffer.clear()
                    numbers.clear()
                    buffer.append(line[i])
                }
                else if (buffer.endsWith("do()")) {
                    enableCommand = true
                    buffer.clear()
                    buffer.append(line[i])
                }
                else if (buffer.endsWith("don't()")) {
                    enableCommand = false
                    buffer.clear()
                    buffer.append(line[i])
                }
                else {
                    buffer.append(line[i])
                }
            }
        }
        return result.toString()
    }

}