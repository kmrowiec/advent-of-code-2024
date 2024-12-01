package solutions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day1Test {

    private val testedClass: Day1 = Day1("example")

    @Test
    fun part1_shouldSolveExample()
    {
        assert("11" == testedClass.part1())
    }

    @Test
    fun part2_shouldSolveExample()
    {
        assert("31" == testedClass.part2())
    }
}