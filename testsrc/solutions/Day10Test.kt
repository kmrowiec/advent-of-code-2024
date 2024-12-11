package solutions
import org.junit.jupiter.api.Test

class Day10Test {

    @Test
    fun part1_shouldSolveExample()
    {
        val result = Day10("example").part1()
        println(result)
        assert("36" == result)
    }

    @Test
    fun part1_shouldSolveActual()
    {
        val result = Day10("actual").part1()
        println(result)
    }

    @Test
    fun part2_shouldSolveExample()
    {
        val result = Day10("example").part2()
        println(result)
        assert("81" == result)
    }

    @Test
    fun part2_shouldSolveActual()
    {
        val result = Day10("actual").part2()
        println(result)
    }
}