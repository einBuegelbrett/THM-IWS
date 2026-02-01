package block_2

import spock.lang.Specification

class FunktionSpecification extends Specification {

    // -------- Aufgabe greet --------

    def "greet() verwendet den Default-Namen 'World'"() {
        expect:
        Funktion.greet() == "Hello World"
    }

    def "greet(name) verwendet den übergebenen Namen"() {
        expect:
        Funktion.greet("Clara") == "Hello Clara"
    }

    // -------- Aufgabe greetInLanguage --------

    def "greetInLanguage() nutzt Default-Werte (World, en)"() {
        expect:
        Funktion.greetInLanguage() == "Hello World"
    }

    def "greetInLanguage(name) nutzt Default-Sprache Englisch"() {
        expect:
        Funktion.greetInLanguage("Anna") == "Hello Anna"
    }

    def "greetInLanguage(name, es) gibt spanische Begrüßung zurück"() {
        expect:
        Funktion.greetInLanguage("Luis", "es") == "Hola Luis"
    }

    def "greetInLanguage(name, de) gibt deutsche Begrüßung zurück"() {
        expect:
        Funktion.greetInLanguage("Clara", "de") == "Hallo Clara"
    }
}
