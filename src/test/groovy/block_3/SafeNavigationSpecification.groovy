package block_3

import spock.lang.Specification

class SafeNavigationSpecification extends Specification {

    def "Gibt Stadt zurück, wenn User und Address vorhanden sind"() {
        given:
        def user = new User(
                name: "Anna",
                address: new Address(city: "Frankfurt")
        )

        expect:
        UserUtils.cityOf(user) == "Frankfurt"
    }

    def "Gibt 'Unknown' zurück, wenn Address null ist"() {
        given:
        def user = new User(name: "Bob", address: null)

        expect:
        UserUtils.cityOf(user) == "Unknown"
    }

    def "Gibt 'Unknown' zurück, wenn User null ist"() {
        expect:
        UserUtils.cityOf(null) == "Unknown"
    }
}
