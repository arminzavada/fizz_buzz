class RepeatingSequence<T>(
    val iterable: Iterable<T>
) : Sequence<T> {

    override fun iterator(): Iterator<T> = object : Iterator<T> {

        private var iterator = iterable.iterator()

        override fun next(): T {
            if (!iterator.hasNext()) {
                iterator = iterable.iterator()
            }

            return iterator.next()
        }

        override fun hasNext(): Boolean {
            return true
        }
    }

}

fun <T> Array<out T>.asRepeatingSequence() = if (isEmpty()) {
    emptySequence()
} else {
    RepeatingSequence(this.toList())
}
fun <T> repeatingSequenceOf(vararg elements: T) = elements.asRepeatingSequence()
