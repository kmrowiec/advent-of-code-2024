package solutions
import org.junit.jupiter.api.Test

class Day7Test {

    @Test
    fun part1_shouldSolveExample()
    {
        val result = Day7("example").part1()
        println(result)
        assert("3749" == result)
    }

    @Test
    fun part1_shouldSolveActual()
    {
        val result = Day7("actual").part1()
        println(result)
    }

    @Test
    fun part2_shouldSolveExample()
    {
        val result = Day7("example").part2()
        println(result)
        assert("11387" == result)
    }

    @Test
    fun part2_shouldSolveActual()
    {
        val result = Day7("actual").part2()
        println(result)
    }
}