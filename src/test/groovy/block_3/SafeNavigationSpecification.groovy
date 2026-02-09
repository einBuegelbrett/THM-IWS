package block_3

import spock.lang.Specification

class EventUtilsSpecification extends Specification {

    def "allNames gibt alle User-Namen zurück"() {
        given:
        def users = [
                new EventUser(name: "Joe", ticketId: 10),
                new EventUser(name: "Bob", ticketId: 20),
                new EventUser(name: "Jacqueline", ticketId: 30)
        ]

        expect:
        EventUtils.allNames(users) == ["Joe", "Bob", "Jacqueline"]
    }

    def "allNames ersetzt null-User durch 'kein Name'"() {
        given:
        def users = [
                new EventUser(name: "Joe", ticketId: 10),
                null,
                new EventUser(name: "Bob", ticketId: 20)
        ]

        expect:
        EventUtils.allNames(users) == ["Joe", "kein Name", "Bob"]
    }

    def "allNames gibt leere Liste bei null zurück"() {
        expect:
        EventUtils.allNames(null) == []
    }

    def "getVipStatusList erkennt VIPs im Range 1..50"() {
        given:
        def users = [
                new EventUser(name: "Joe", ticketId: 50),
                new EventUser(name: "Jacqueline", ticketId: 10)
        ]

        when:
        def result = EventUtils.getVipStatusList(users)

        then:
        result == [
                "Joe ist ein VIP",
                "Jacqueline ist ein VIP"
        ]
    }

    def "getVipStatusList erkennt Nicht-VIPs korrekt"() {
        given:
        def users = [
                new EventUser(name: "Bob", ticketId: 150)
        ]

        when:
        def result = EventUtils.getVipStatusList(users)

        then:
        result == ["Bob ist kein VIP"]
    }

    def "getVipStatusList verarbeitet gemischte Liste inkl null"() {
        given:
        def users = [
                new EventUser(name: "Joe", ticketId: 50),
                new EventUser(name: "Bob", ticketId: 150),
                null
        ]

        when:
        def result = EventUtils.getVipStatusList(users)

        then:
        result == [
                "Joe ist ein VIP",
                "Bob ist kein VIP",
                "Gast ist kein VIP"
        ]
    }

    def "getVipStatusList gibt leere Liste bei null zurück"() {
        expect:
        EventUtils.getVipStatusList(null) == []
    }
}
