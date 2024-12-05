package solutions
import org.junit.jupiter.api.Test

class DayXTest {

    @Test
    fun part1_shouldSolveExample()
    {
        val result = DayX("example").part1()
        println(result)
        assert("0" == result)
    }

    @Test
    fun part1_shouldSolveActual()
    {
        val result = DayX("actual").part1()
        println(result)
    }

    @Test
    fun part2_shouldSolveExample()
    {
        val result = DayX("example").part2()
        println(result)
        assert("0" == result)
    }

    @Test
    fun part2_shouldSolveActual()
    {
        val result = DayX("actual").part2()
        println(result)
    }
}