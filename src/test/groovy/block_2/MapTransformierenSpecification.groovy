package block_2

import spock.lang.Specification

class MapTransformierenSpecification extends Specification {

    def prices = [
            apple : 1.2,
            banana: 0.8,
            orange: 1.5
    ]

    def "Aufgabe Preise werden um 10 Prozent erhöht"() {
        expect:
        MapTransformer.increasePrices(prices) == [
                apple : 1.32,
                banana: 0.88,
                orange: 1.65
        ]
    }

    def "Aufgabe Nur Preise größer als 1.0 bleiben erhalten"() {
        expect:
        MapTransformer.expensiveProducts(prices) == [
                apple : 1.2,
                orange: 1.5
        ]
    }

    def "Aufgabe Alle Produktnamen werden extrahiert"() {
        expect:
        MapTransformer.uppercaseKeys(prices) == [
                APPLE : 1.2,
                BANANA: 0.8,
                ORANGE: 1.5
        ]
    }
}
