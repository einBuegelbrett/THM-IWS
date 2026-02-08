package block_2

import spock.lang.Specification

class ListeFilternSpecification extends Specification {

    def "Aufgabe Alle ungeraden Zahlen filtern"() {
        given:
        def list = [1, 2, 3, 4, 5]

        expect:
        ListFilter.oddNumbers(list) == [1, 3, 5]
    }

    def "Aufgabe Alle Zahlen größer als 3 filtern"() {
        given:
        def numbers = [1, 2, 3, 4, 5, 6]

        expect:
        ListFilter.greaterThanThree(numbers) == [4, 5, 6]
    }

    def "Aufgabe Alle Wörter mit mehr als 4 Buchstaben filtern"() {
        given:
        def words = ["Groovy", "Java", "Kotlin", "Go", "Scala"]

        expect:
        ListFilter.wordsLongerThanFour(words) == ["Groovy", "Kotlin", "Scala"]
    }

    def "Aufgabe Alle Zahlen größer als 2 filtern, quadrieren und sortieren"() {
        given:
        def numbers = [9, 7, 1, 3, 5]

        expect:
        ListFilter.processNumbers(numbers) == [9, 25, 49, 81]
    }
}