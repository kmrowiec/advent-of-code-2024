package solutions
import org.junit.jupiter.api.Test

class Day6Test {

    @Test
    fun part1_shouldSolveExample()
    {
        val result = Day6("example").part1()
        println(result)
        assert("41" == result)
    }

    @Test
    fun part1_shouldSolveActual()
    {
        val result = Day6("actual").part1()
        println(result)
    }

    @Test
    fun part2_shouldSolveExample()
    {
        val result = Day6("example").part2()
        println(result)
        assert("6" == result)
    }

    @Test
    fun part2_shouldSolveActual()
    {
        val result = Day6("actual").part2()
        println(result)
    }
}