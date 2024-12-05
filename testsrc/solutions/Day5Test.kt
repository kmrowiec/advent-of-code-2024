package solutions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 5")
class Day5Test {

    @Test
    fun part1_shouldSolveExample()
    {
        val result = Day5("example").part1()
        println(result)
        assert("143" == result)
    }

    @Test
    fun part1_shouldSolveActual()
    {
        val result = Day5("actual").part1()
        println(result)
    }

    @Test
    fun part2_shouldFixLine()
    {
        val result = Day5("example").fixLine("97,13,75,29,47")
        println(result)
        assert(listOf("97" ,"75", "47" ,"29", "13") == result)
    }

    @Test
    fun part2_shouldSolveExample()
    {
        val result = Day5("example").part2()
        println(result)
        assert("123" == result)
    }

    @Test
    fun part2_shouldSolveActual()
    {
        val result = Day5("actual").part2()
        println(result)
    }
}