package block_2

// https://groovy-lang.org/objectorientation.html#_default_arguments

/**
 * Aufgabe 4:
 * Schreibe Funktionen mit Default-Parametern
 * Thema: Groovy Vibes
 */
static void main(String[] args) {

    println "Aufgabe Groove-Intro:"
    println Funktion.welcome()
    println Funktion.welcome("Clara")
    println()

    println "Aufgabe Groove-Greeting in verschiedenen Sprachen:"
    println Funktion.greetInLanguage()
    println Funktion.greetInLanguage("Anna")
    println Funktion.greetInLanguage("Luis", "es")
    println()
}

class Funktion {

    /**
     * Begrüßt jemanden zur Session.
     * Standard-Name ist "Groover".
     *
     * Beispiele:
     * welcome() -> "Welcome to the groove, Groover!"
     * welcome("Clara") -> "Welcome to the groove, Clara!"
     */
    static String welcome(String name = "Groover") {
        "Welcome to the groove, ${name}!"
    }

    /**
     * Begrüßt jemanden im Groove – abhängig von der Sprache.
     *
     * Defaults:
     * name = "Groover"
     * language = "en"
     *
     * Optionen: de, es, fr, en
     *
     * Beispiele:
     * greetInLanguage() -> "Hello Groover, feel the groove!"
     * greetInLanguage("Anna") -> "Hello Anna, feel the groove!"
     * greetInLanguage("Anna", "de") -> "Hallo Anna, fühl den groove!"
     * greetInLanguage("Luis", "es") -> "Hola Luis, siente el groove!"
     * greetInLanguage("Luis", "fr") -> "Bonjour Luis, sentir le groove!"
     */
    static String greetInLanguage(String name = "Groover", String language = "en") {
        switch (language) {
            case "de":
                return "Hallo ${name}, fühl den Groove!"
            case "es":
                return "Hola ${name}, siente el groove!"
            case "fr":
                return "Bonjour ${name}, sentir le groove!"
            default:
                return "Hello ${name}, feel the groove!"
        }
    }
}
