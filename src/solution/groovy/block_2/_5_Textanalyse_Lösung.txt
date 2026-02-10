package block_2

/**
 * Aufgabe 5: Wandele die Java-Funktionen zur Textanalyse in Groovy-Code mit Closures um.
 */
static void main(String[] args) {

    def text = "Groovy is cool and Groovy is powerful"

    println "Text:"
    println text
    println()

    println "Aufgabe Wortanzahl:"
    println TextAnalysis.wordCount(text)
    println()

    println "Aufgabe Anzahl eines bestimmten Wortes (\"Groovy\"):"
    println TextAnalysis.countWord(text, "Groovy")
    println()

    println "Aufgabe Wörter mit Mindestanzahl an Zeichen:"
    println TextAnalysis.wordsLongerThan(text, 4)
}


class TextAnalysis {

    /**
     * Zähle die Anzahl der Wörter in einem Text
     *
     * String[] words = text.split(" ");
     * int count = 0;
     * for (String word : words) {
     *     count++;
     * }
     * return count;
     */
    static int wordCount(String text) {
        text.split(" ").size()
    }

    /**
     * Zähle, wie oft ein bestimmtes Wort vorkommt
     *
     * int count = 0;
     * for (String word : text.split(" ")) {
     *     if (word.equals(search)) {
     *         count++;
     *     }
     * }
     * return count;
     */
    static int countWord(String text, String search) {
        text.split(" ").count { it == search }
    }

    /**
     * Filtere alle Wörter, die länger als eine gegebene Länge sind
     *
     * List<String> result = new ArrayList<>();
     * for (String word : text.split(" ")) {
     *     if (word.length() > minLength) {
     *         result.add(word);
     *     }
     * }
     * return result;
     */
    static List<String> wordsLongerThan(String text, int minLength) {
        text.split(" ").findAll { it.length() > minLength }
    }
}
