private val fizzes = repeatingSequenceOf("", "", "Fizz")
private val buzzes = repeatingSequenceOf("", "", "", "", "Buzz")
private val words = fizzes.zip(buzzes) { a, b ->
    a + b
}
private val numbers = generateSequence(1) { it + 1 }
private val fizzbuzz = numbers.zip(words) { a, b ->
    b.ifEmpty {
        a.toString()
    }
}

fun fizzBuzz(count: Int) = fizzbuzz.take(count)
