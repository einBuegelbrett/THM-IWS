package block_2

// https://www.baeldung.com/groovy-maps

/**
 * Aufgabe 3: Wandele die Java-Funktionen zur Verarbeitung von Maps
 * in Groovy-Code mit Closures um.
 */
static void main(String[] args) {
    def prices = [
            apple : 1.2,
            banana: 0.8,
            orange: 1.5,
            mango : 2.5
    ]

    println "Aufgabe Nur teure Produkte (> 1.0):"
    println MapTransformer.expensiveProducts(prices)
    println()

    println "Aufgabe Preise um 10% erhöhen:"
    println MapTransformer.increasePrices(prices)
    println()

    println "Aufgabe Produktnamen in Großbuchstaben:"
    println MapTransformer.uppercaseKeys(prices)
    println()
}

class MapTransformer {

    /**
     * Alle Produkte filtern, deren Preis größer als 1.0 ist
     *
     * Map<String, BigDecimal> result = new HashMap<>();
     * for (Map.Entry<String, BigDecimal> entry : prices.entrySet()) {
     *     if (entry.getValue().compareTo(BigDecimal.valueOf(1.0)) > 0) {
     *         result.put(entry.getKey(), entry.getValue());
     *     }
     * }
     */
    static Map<String, BigDecimal> expensiveProducts(Map<String, BigDecimal> prices) {
        prices.findAll { key, value ->
            value > 1.0
        }
    }

    /**
     * Alle Preise um 10% erhöhen
     *
     * Map<String, BigDecimal> result = new HashMap<>();
     * for (Map.Entry<String, BigDecimal> entry : prices.entrySet()) {
     *     result.put(
     *         entry.getKey(),
     *         entry.getValue().multiply(BigDecimal.valueOf(1.1))
     *     );
     * }
     */
    static Map<String, BigDecimal> increasePrices(Map<String, BigDecimal> prices) {
        prices.collectEntries { key, value ->
            [(key): (value * 1.1)]
        }
    }

    /**
     * Alle Produktnamen (Keys) in Großbuchstaben umwandeln
     *
     * Map<String, BigDecimal> result = new HashMap<>();
     * for (Map.Entry<String, BigDecimal> entry : prices.entrySet()) {
     *     result.put(entry.getKey().toUpperCase(), entry.getValue());
     * }
     */
    static Map<String, BigDecimal> uppercaseKeys(Map<String, BigDecimal> prices) {
        prices.collectEntries { key, value ->
            [(key.toUpperCase()): value]
        }
    }
}
