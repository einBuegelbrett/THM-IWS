package block_2

// https://groovy-lang.org/closures.html
// https://www.youtube.com/watch?v=Xn6NXGpNWMc

/**
 * Aufgabe 2: Wandele die Java-Funktionen in Groovy-Code mit Closures um.
 */
static void main(String[] args) {
    def numbers = [1,2,3,4,5]
    def words = ["Groovy", "Java", "Kotlin", "Go", "Scala"]

    println "Aufgabe Ungerade Zahlen:"
    println ListFilter.oddNumbers(numbers)
    println()

    println "Aufgabe Zahlen größer als 3:"
    println ListFilter.greaterThanThree(numbers)
    println()

    println "Aufgabe Wörter mit mehr als 4 Buchstaben:"
    println ListFilter.wordsLongerThanFour(words)
}

class ListFilter {
    /**
     * Alle ungeraden Zahlen filtern
     *
     * for (int item : list) {
     *     if (item % 2 != 0) {
     *         result.add(item);
     *     }
     * }
     */
    static List<Integer> oddNumbers(List<Integer> list) {
        list.findAll { it % 2 }
    }

    /**
     * Alle Zahlen größer als 3 filtern
     *
     * for (int n : numbers) {
     *     if (n > 3) {
     *         result.add(n);
     *     }
     * }
     */
    static List<Integer> greaterThanThree(List<Integer> numbers) {
        numbers.findAll { it > 3 }
    }

    /**
     * Alle Wörter mit mehr als 4 Buchstaben filtern
     *
     * for (String word : words) {
     *     if (word.length() > 4) {
     *         result.add(word);
     *     }
     * }
     */
    static List<String> wordsLongerThanFour(List<String> words) {
        words.findAll { it.length() > 4 }
    }
}
