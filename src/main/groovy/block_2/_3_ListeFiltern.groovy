package block_2

// https://groovy-lang.org/closures.html
// https://www.youtube.com/watch?v=Xn6NXGpNWMc

/**
 * Aufgabe 2: Wandele die Java-Funktionen in Groovy-Code mit Closures um.
 */
static void main(String[] args) {
    def numbers = [1,2,3,4,5]
    def words = ["Groovy", "Java", "Kotlin", "Go", "Scala"]
    def numbersUnsorted = [5,7,1,3]

    println "Aufgabe Ungerade Zahlen:"
    println ListFilter.oddNumbers(numbers)
    println()

    println "Aufgabe Wörter mit mehr als 4 Buchstaben:"
    println ListFilter.wordsLongerThanFour(words)

    println "Aufgabe Zahlen filtern und verarbeiten:"
    println ListFilter.processNumbers(numbersUnsorted)
    println()

    println "Aufgabe Bestimmte Zahlen eindeutig sortieren:"
    println ListFilter.selectedUniqueNumbers(
            [1, 2, 2, 3, 4, 5, 5, 6],
            [2, 4, 6, 8]
    )
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

    /**
     * Alle Zahlen größer als 2 filtern, quadrieren und aufsteigend sortieren
     *
     * for (int n : numbers) {
     *     if (n > 2) {
     *         result.add(n * n);
     *     }
     * }
     * Collections.sort(result);
     */
    static List<Integer> processNumbers(List<Integer> numbers) {
        numbers
            .findAll { it > 2 }
            .collect { it * it }
            .sort()
    }

    /**
    * Alle Zahlen auswählen, die in der zweiten Liste enthalten sind,
    * Duplikate entfernen und aufsteigend sortieren
    *
    * for (int n : numbers) {
    *     if (allowed.contains(n)) {
    *         result.add(n);
    *     }
    * }
    *
    * result = result.stream()
    *     .distinct()
    *     .sorted()
    *     .collect(Collectors.toList());
    */
    static List<Integer> selectedUniqueNumbers(List<Integer> numbers, List<Integer> allowed ) {
        numbers
            .findAll { allowed.contains(it) }
            .unique()
            .sort()
    }
}
