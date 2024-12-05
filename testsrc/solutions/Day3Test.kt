package solutions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 3")
class Day3Test {

    private val testedClass: Day3 = Day3("example")

    @Test
    fun part1_shouldSolveExample()
    {
        val result = testedClass.part1()
        println(result)
        assert("161" == result)
    }

    @Test
    fun part1_parseLine_input1()
    {
        val result = testedClass.parseLine("mul(2,3)")
        println(result)
        assert(6 == result)
    }

    @Test
    fun part1_parseLine_input2()
    {
        val result = testedClass.parseLine("mul(2,3)mul(3,3)")
        println(result)
        assert(15 == result)
    }


    @Test
    fun part2_shouldSolveExample()
    {
        val result = Day3("example2").part2()
        println(result)
        assert("48" == result)
    }
}