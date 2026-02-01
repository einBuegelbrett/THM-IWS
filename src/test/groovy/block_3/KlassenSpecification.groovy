package block_3

import spock.lang.Specification

class KlassenSpecification extends Specification {

    def "fullName gibt Vor- und Nachnamen zurück"() {
        given:
        def person = new Person(
                firstName: "Max",
                lastName: "Mustermann",
                age: 25
        )

        expect:
        person.fullName() == "Max Mustermann"
    }

    def "isAdult ist true bei Alter >= 18"() {
        expect:
        new Person(firstName: "Anna", lastName: "Schmidt", age: 18).isAdult()
    }

    def "isAdult ist false bei Alter < 18"() {
        expect:
        !new Person(firstName: "Tom", lastName: "Klein", age: 16).isAdult()
    }

    def "description gibt formatierte Beschreibung zurück"() {
        given:
        def person = new Person(
                firstName: "Lisa",
                lastName: "Meyer",
                age: 30
        )

        expect:
        person.description() == "Lisa Meyer (30 Jahre)"
    }
}
