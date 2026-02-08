package block_3

import spock.lang.Specification

class PipelineProcessorSpecification extends Specification {

    def "Pipeline filtert INFO-Zeilen und erzeugt LogEntry-Objekte"() {
        given: "Eine Liste mit verschiedenen Log-Levels"
        def input = [
                "INFO: Groovy ist cool",
                "DEBUG: Details",
                "INFO: Lernen ist toll"
        ]

        when: "Die Pipeline mit einer einfachen Großschreib-Transformation aufgerufen wird"
        def result = PipelineProcessor.process(input) { it.toUpperCase() }

        then: "Nur INFO-Einträge sind vorhanden und korrekt transformiert"
        result.size() == 2
        result[0] instanceof LogEntry
        result[0].level == "INFO"
        result[0].message == "GROOVY IST COOL"
        result[1].message == "LERNEN IST TOLL"
    }

    def "Pipeline ist robust gegenüber null-Einträgen in der Liste"() {
        given: "Eine Liste mit null-Werten"
        def input = [null, "INFO: Hallo", null]

        when:
        def result = PipelineProcessor.process(input) { it }

        then: "Die null-Werte wurden einfach ignoriert"
        result.size() == 1
        result[0].message == "Hallo"
    }

    def "Pipeline gibt leere Liste bei null-Eingabe der gesamten Liste zurück"() {
        expect:
        PipelineProcessor.process(null) { it } == []
    }

    def "Die Transformation-Closure wird korrekt angewendet"() {
        given: "Ein INFO-Eintrag"
        def input = ["INFO: Test"]

        when: "Eine Closure mit Präfix übergeben wird"
        def result = PipelineProcessor.process(input) { "MSG: $it" }

        then:
        result[0].message == "MSG: Test"
    }
}