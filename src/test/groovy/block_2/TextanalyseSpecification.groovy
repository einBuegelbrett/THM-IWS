package block_2

import spock.lang.Specification

class TextanalyseSpecification extends Specification {

    def text = "Groovy macht Groovy Code kurz und lesbar"

    def "Aufgabe Wortanzahl wird korrekt berechnet"() {
        expect:
        TextAnalysis.wordCount(text) == 7
    }

    def "Aufgabe Wortvorkommen wird korrekt gezählt (case-insensitive)"() {
        expect:
        TextAnalysis.countWord(text, "Groovy") == 2
    }

    def "Aufgabe Wörter länger als gegebene Länge werden gefiltert"() {
        expect:
        TextAnalysis.wordsLongerThan(text, 4) == [
                "Groovy",
                "macht",
                "Groovy",
                "lesbar"
        ]
    }
}
