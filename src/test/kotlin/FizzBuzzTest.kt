import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FizzBuzzTest {

    private val count = 15 * 100000 // multiple of fifteen, in order to not be bitten by the chunked function.

    @Test
    fun onlyAllowedValues() {
        Assertions.assertTrue(fizzBuzz(count).all { it == "Fizz" || it == "Buzz" || it == "FizzBuzz" || it.toIntOrNull() != null })
    }

    @Test
    fun numbersAtTheRightPlace() {
        Assertions.assertTrue(
            fizzBuzz(count).mapIndexed { index, it ->
                val num = it.toIntOrNull()
                if (num != null) {
                    num == index + 1
                } else true
            }.all { it }
        )
    }

    @Test
    fun everyThirdIsFizz() {
        Assertions.assertTrue(fizzBuzz(count).chunked(3) { it.last() }.all { it.contains("Fizz") })
    }

    @Test
    fun everyFifthIsBuzz() {
        Assertions.assertTrue(fizzBuzz(count).chunked(5) { it.last() }.all { it.contains("Buzz") })
    }

    @Test
    fun everyFifteenthIsFizzBuzz() {
        Assertions.assertTrue(fizzBuzz(count).chunked(15) { it.last() }.all { it.contains("FizzBuzz") })
    }

    @Test
    fun allFizzesAtRightPlace() {
        Assertions.assertTrue(fizzBuzz(count).mapIndexed { index, it -> it != "Fizz" || (index + 1) % 3 == 0 }.all { it })
    }

    @Test
    fun allBuzzesAtRightPlace() {
        Assertions.assertTrue(fizzBuzz(count).mapIndexed { index, it -> it != "Buzz" || (index + 1) % 5 == 0 }.all { it })
    }

    @Test
    fun allFizzBuzzesAtRightPlace() {
        Assertions.assertTrue(fizzBuzz(count).mapIndexed { index, it -> it != "FizzBuzz" || (index + 1) % 15 == 0 }.all { it })
    }

}
