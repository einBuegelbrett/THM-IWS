package block_2

// https://groovy-lang.org/objectorientation.html#_default_arguments

/**
 * Aufgabe 4:
 * Schreibe Funktionen mit Default-Parametern
 */
static void main(String[] args) {
    println "Aufgabe Begrüßung mit Default-Namen:"
    println Funktion.greet()
    println Funktion.greet("Clara")
    println()

    println "Aufgabe Begrüßung mit Sprache:"
    println Funktion.greetInLanguage()
    println Funktion.greetInLanguage("Anna")
    println Funktion.greetInLanguage("Luis", "es")
    println()
}

class Funktion {

    /**
     * Begrüßt eine Person.
     * Standardname ist "World".
     *
     * Beispiel:
     * greet()        -> "Hello World"
     * greet("Clara")  -> "Hello Clara"
     */
    static String greet(String name = "World") {
        "Hello ${name}"
    }

    /**
     * Begrüßt eine Person in einer bestimmten Sprache
     *
     * Default:
     * name = "World"
     * language = "en"
     *
     * Optionen: de, es, fr, en
     *
     * Beispiele:
     * greetInLanguage() -> "Hello World"
     * greetInLanguage("Anna") -> "Hello Anna"
     * greetInLanguage("Luis", "es") -> "Hola Luis"
     */
    static String greetInLanguage(String name = "World", String language = "en") {
        switch (language) {
            case "de": return "Hallo ${name}"
            case "es": return "Hola ${name}"
            case "fr": return "Bonjour ${name}"
            default:   return "Hello ${name}"
        }
    }
}
