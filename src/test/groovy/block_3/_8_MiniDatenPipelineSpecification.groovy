package block_3

import spock.lang.Specification

class _8_MiniDatenPipelineSpecification extends Specification {

    def "Pipeline filtert INFO-Zeilen und formatiert korrekt"() {
        given:
        def input = [
                "INFO: Groovy ist cool",
                "DEBUG: Details",
                "ERROR: Etwas ging schief",
                "INFO: Lernen ist toll"
        ]

        when:
        def result = MiniPipeline.process(input)

        then:
        result == [
                "✔ GROOVY IST COOL",
                "✔ LERNEN IST TOLL"
        ]
    }

    def "Pipeline ignoriert null-Werte (Safe Navigation)"() {
        given:
        def input = [
                null,
                "INFO: Hallo",
                null
        ]

        expect:
        MiniPipeline.process(input) == [
                "✔ HALLO"
        ]
    }

    def "Pipeline gibt leere Liste bei null-Eingabe zurück"() {
        expect:
        MiniPipeline.process(null) == []
    }

    def "Pipeline gibt leere Liste zurück, wenn keine INFO-Zeilen vorhanden sind"() {
        given:
        def input = [
                "DEBUG: Test",
                "WARN: Achtung",
                "ERROR: Fehler"
        ]

        expect:
        MiniPipeline.process(input) == []
    }
}
