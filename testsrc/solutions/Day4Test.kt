package solutions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 4")
class Day4Test {

    @Test
    fun part1_shouldSolveExample()
    {
        val result = Day4("example").part1()
        println(result)
        assert("18" == result)
    }

    @Test
    fun part1_shouldSolveActual()
    {
        val result = Day4("actual").part1()
        println(result)
    }

    @Test
    fun part2_shouldSolveExample()
    {
        val result = Day4("example2").part2()
        println(result)
        assert("9" == result)
    }

    @Test
    fun part2_shouldSolveActual()
    {
        val result = Day4("actual").part2()
        println(result)
    }
}