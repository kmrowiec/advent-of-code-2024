package solutions
import org.junit.jupiter.api.Test

class Day11Test {

    @Test
    fun part1_shouldSolveSimpleExample()
    {
        val result = Day11("example").solve(6)
        println(result)
        assert("22" == result)
    }

    @Test
    fun part1_shouldSolveExample()
    {
        val result = Day11("example").part1()
        println(result)
        assert("55312" == result)
    }

    @Test
    fun part1_shouldSolveActual()
    {
        val result = Day11("actual").part1()
        println(result)
    }

    @Test
    fun part2_shouldSolveExample()
    {
        val result = Day11("example").part2()
        println(result)
        assert("65601038650482" == result)
    }

    @Test
    fun part2_shouldSolveActual()
    {
        val result = Day11("actual").part2()
        println(result)
    }
}