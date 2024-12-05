package solutions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
class Day2Test {

    private val testedClass: Day2 = Day2("example")

    @Test
    fun part1_shouldSolveExample()
    {
        val result = testedClass.part1()
        println(result)
        assert("2" == result)
    }

    @Test
    fun part2_shouldSolveExample()
    {
        val result = testedClass.part2()
        println(result)
        assert("4" == result)
    }
}