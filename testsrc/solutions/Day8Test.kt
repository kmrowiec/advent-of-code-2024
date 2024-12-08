package solutions
import org.junit.jupiter.api.Test

class Day8Test {

    @Test
    fun part1_shouldSolveExample()
    {
        val result = Day8("example").part1()
        println(result)
        assert("14" == result)
    }

    @Test
    fun part1_shouldSolveActual()
    {
        val result = Day8("actual").part1()
        println(result)
    }

    @Test
    fun part2_shouldSolveExample()
    {
        val result = Day8("example").part2()
        println(result)
        assert("34" == result)
    }

    @Test
    fun part2_shouldSolveActual()
    {
        val result = Day8("actual").part2()
        println(result)
    }
}