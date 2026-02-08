package block_3

import spock.lang.Specification
import spock.lang.Subject

class EventUtilsSpec extends Specification {

    def "allNames sollte alle Namen extrahieren und null-User ignorieren"() {
        given: "Eine Liste mit Usern und einem null-Eintrag"
        def users = [
            new EventUser(name: "Alice", ticketId: 10),
            null,
            new EventUser(name: "Charlie", ticketId: 20)
        ]

        when: "allNames aufgerufen wird"
        def names = EventUtils.allNames(users)

        then: "Sind nur die validen Namen in der Liste"
        names == ["Alice", "Charlie"]
        names.size() == 2
    }

    def "allNames sollte eine leere Liste bei null-Eingabe zurückgeben"() {
        expect:
        EventUtils.allNames(null) == []
    }

    def"getVipStatusList sollte VIPs korrekt identifizieren (Range 1-50)"() {
        given: "User mit unterschiedlichen Ticket-IDs"
        def users = [
            new EventUser(name: "Alice", ticketId: 50),  // Grenze VIP
            new EventUser(name: "Bob", ticketId: 51),    // Knapp kein VIP
            new EventUser(name: "Charlie", ticketId: 1), // VIP
            null                                         // Sollte ignoriert/sicher behandelt werden
        ]

        when:
        def results = EventUtils.getVipStatusList(users)

        then: "Stimmen die Status-Meldungen"
        results.contains("Alice ist VIP")
        results.contains("Bob ist kein VIP")
        results.contains("Charlie ist VIP")
        results.size() == 3 // null-Eintrag erzeugt keinen String in der Liste (laut deiner Logik)
    }

    def "getVipStatusList sollte 'Gast' verwenden, wenn der Name null ist"() {
        given: "Ein User ohne Namen aber mit VIP Ticket"
        def users = [new EventUser(name: null, ticketId: 25)]

        expect:
        EventUtils.getVipStatusList(users) == ["Gast ist VIP"]
    }
}