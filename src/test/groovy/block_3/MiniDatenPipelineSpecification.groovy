package block_3

import spock.lang.Specification

class PipelineProcessorSpecification extends Specification {

    def "Pipeline filtert nur STAGE-Nachrichten"() {
        given:
        def input = [
                "STAGE: Mic Check",
                "SECURITY: Eingang voll",
                "STAGE: Monitor anpassen"
        ]

        when:
        def result = PipelineProcessor.process(input) { it }

        then:
        result.size() == 2
        result*.type == ["STAGE", "STAGE"]
    }

    def "Pipeline erzeugt RadioLog Objekte"() {
        given:
        def input = ["STAGE: Test"]

        when:
        def result = PipelineProcessor.process(input) { it }

        then:
        result[0] instanceof RadioLog;
        result[0].type == "STAGE";
        result[0].content == "Test";
    }

    def "Transformation-Closure wird angewendet"() {
        given:
        def input = ["STAGE: mic check"]

        when:
        def result = PipelineProcessor.process(input) { it.toUpperCase() }

        then:
        result[0].content == "MIC CHECK"
    }

    def "Pipeline ignoriert null und leere Einträge"() {
        given:
        def input = [
                null,
                "",
                "STAGE: Soundcheck",
                "VIP: Champagner leer"
        ]

        when:
        def result = PipelineProcessor.process(input) { it }

        then:
        result.size() == 1
        result[0].content == "Soundcheck"
    }

    def "Pipeline verarbeitet mehrere STAGE-Einträge in Reihenfolge"() {
        given:
        def counter = 1
        def input = [
                "STAGE: A",
                "STAGE: B",
                "STAGE: C"
        ]

        when:
        def result = PipelineProcessor.process(input) {
            "MSG ${counter++}: $it"
        }

        then:
        result*.content == [
                "MSG 1: A",
                "MSG 2: B",
                "MSG 3: C"
        ]
    }

    def "Pipeline gibt leere Liste bei null-Input zurück"() {
        expect:
        PipelineProcessor.process(null) { it } == []
    }

    def "Pipeline verarbeitet Nachrichten ohne Doppelpunkt korrekt"() {
        given:
        def input = ["STAGE"]

        when:
        def result = PipelineProcessor.process(input) { it ?: "EMPTY" }

        then:
        result.size() == 1
        result[0].type == "STAGE"
        result[0].content == "EMPTY"
    }
}
