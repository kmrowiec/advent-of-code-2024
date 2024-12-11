package solutions
import org.junit.jupiter.api.Test

class Day9Test {

    @Test
    fun part1_shouldSolveSimpleExample()
    {
        val result = Day9("example").part1()
        println(result)
    }

    @Test
    fun part1_shouldSolveExample()
    {
        val result = Day9("example2").part1()
        println(result)
        assert("1928" == result)
    }

    @Test
    fun part1_shouldSolveActual()
    {
        val result = Day9("actual").part1()
        println(result)
    }

    @Test
    fun part2_shouldSolveExample()
    {
        val result = Day9("example2").part2()
        println(result)
        assert("2858" == result)
    }

    @Test
    fun part2_shouldSolveActual()
    {
        val result = Day9("actual").part2()
        println(result)
    }
}