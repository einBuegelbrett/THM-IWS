package block_2

import spock.lang.Specification

class FunktionSpecification extends Specification {

    // -------- Aufgabe welcome --------

    def "welcome() verwendet den Default-Namen 'Groover'"() {
        expect:
        Funktion.welcome() == "Welcome to the groove, Groover!"
    }

    def "welcome(name) verwendet den übergebenen Namen"() {
        expect:
        Funktion.welcome("Clara") == "Welcome to the groove, Clara!"
    }

    // -------- Aufgabe greetInLanguage --------

    def "greetInLanguage() nutzt Default-Werte (Groover, en)"() {
        expect:
        Funktion.greetInLanguage() == "Hello Groover, feel the groove!"
    }

    def "greetInLanguage(name) nutzt Default-Sprache Englisch"() {
        expect:
        Funktion.greetInLanguage("Anna") == "Hello Anna, feel the groove!"
    }

    def "greetInLanguage(name, es) gibt spanische Groove-Begrüßung zurück"() {
        expect:
        Funktion.greetInLanguage("Luis", "es") == "Hola Luis, siente el groove!"
    }

    def "greetInLanguage(name, de) gibt deutsche Groove-Begrüßung zurück"() {
        expect:
        Funktion.greetInLanguage("Clara", "de") == "Hallo Clara, fühl den Groove!"
    }

    def "greetInLanguage(name, fr) gibt französische Groove-Begrüßung zurück"() {
        expect:
        Funktion.greetInLanguage("Luis", "fr") == "Bonjour Luis, sens le groove!"
    }
}
