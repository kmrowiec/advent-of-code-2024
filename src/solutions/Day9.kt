package solutions

import Solver

class Day9(version: String) : Solver(9, version)
{
    override fun part1(): String
    {
        var result = 0L
        var disk = mutableListOf<Int>()
        var fileIndex = 0
        var isFile = true

        for (index in inputLines[0].indices)
        {
            val span = inputLines[0].get(index).toString().toInt()
            if(isFile)
            {
                for (i in 0..<span)
                {
                    disk.add(fileIndex)
                }
            } else {
                for (i in 0..<span)
                {
                    disk.add(-1)
                }
                fileIndex++
            }
            isFile = !isFile
        }

        for(value in disk)
        {
            print( if (value == -1) "." else value.toString())
        }
        println()

        var front = 0
        var back = disk.size-1

        while(front<back)
        {
            while (disk[front] != -1) {
                front++
            }

            while (disk[back] == -1) {
                back--
            }

            if(front < back)
            {
                disk[front] = disk[back]
                disk[back] = -1
            }
        }

        for(value in disk)
        {
            print( if (value == -1) "." else value.toString())
        }
        println()

        for(i in disk.indices)
        {
            if(disk[i] == -1) break
            result += disk[i] * i
        }

        return result.toString()
    }

    override fun part2(): String
    {
        var result = 0L
        var disk = mutableListOf<Int>()
        var fileIndex = 0
        var isFile = true

        for (index in inputLines[0].indices)
        {
            val span = inputLines[0].get(index).toString().toInt()
            if(isFile)
            {
                for (i in 0..<span)
                {
                    disk.add(fileIndex)
                }
            } else {
                for (i in 0..<span)
                {
                    disk.add(-1)
                }
                fileIndex++
            }
            isFile = !isFile
        }

        for(value in disk)
        {
            print( if (value == -1) "." else value.toString())
        }
        println()


        var back = disk.size-1

        while(back > 0)
        {
            // Find the last file that can be moved
            while (disk[back] == -1 && back > 0) {
                back--
            }

            if (back <= 0) break

            // Find where file begins
            var startOfFile = back
            while (startOfFile > 0 && disk[startOfFile] == disk[back]) {
                startOfFile--
            }
            startOfFile += 1

            val fileSize = back - startOfFile + 1

            println("File found! ${disk[back]} at ${startOfFile} - ${back}, size ${fileSize}")

            // Find gap large enough to fit the file
            var front = 0
            var gapEnd = 0

            var gapSize = -1
            while (gapEnd < startOfFile && gapSize < fileSize && front < startOfFile) {
                while (disk[front] != -1) {
                    front++
                }
                gapEnd = front
                while (gapEnd+1 < disk.size-1 && disk[gapEnd+1] == -1) {
                    gapEnd++
                }
                gapSize = gapEnd - front + 1
                if(gapSize < fileSize) {
                    front = gapEnd + 1
                }
            }

            if(gapSize >= fileSize && gapEnd < startOfFile)
            {
                for (i in front..<front + fileSize) {
                    disk[i] = disk[back]
                }
                for (i in startOfFile..back) {
                    disk[i] = -1
                }
            } else {
                back = startOfFile - 1
            }

        }

        for(value in disk)
        {
            print( if (value == -1) "." else value.toString())
        }
        println()

        for(i in disk.indices)
        {
            if(disk[i] == -1) continue
            result += disk[i] * i
        }

        return result.toString()
    }
}