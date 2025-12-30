package block_3

/**
 * Implementiere eine Methode, die den Städtenamen eines Users zurückgibt.
 *
 * Anforderungen:
 * - Gibt den Städtenamen zurück, wenn alle Werte vorhanden sind
 * - Gibt "Unknown" zurück, wenn
 *   - der User null ist
 *   - die Adresse null ist
 *   - die Stadt null ist
 *
 * Java-Beispiel:
 *
 * String city;
 * if (user != null) {
 *     if (user.getAddress() != null) {
 *         if (user.getAddress().getCity() != null) {
 *             city = user.getAddress().getCity();
 *         } else {
 *             city = "Unknown";
 *         }
 *     } else {
 *         city = "Unknown";
 *     }
 * } else {
 *     city = "Unknown";
 * }
 */
static void main(String[] args) {

    println "Aufgabe Safe Navigation & Elvis"
    println()

    def userWithCity = new User(
            name: "Anna",
            address: new Address(city: "Berlin")
    )

    def userWithoutAddress = new User(
            name: "Tom",
            address: null
    )

    def userWithNullCity = new User(
            name: "Eva",
            address: new Address(city: null)
    )

    def noUser = null

    println "User mit Stadt:"
    println UserUtils.cityOf(userWithCity)
    println()

    println "User ohne Adresse:"
    println UserUtils.cityOf(userWithoutAddress)
    println()

    println "User mit Adresse, aber ohne Stadt:"
    println UserUtils.cityOf(userWithNullCity)
    println()

    println "User ist null:"
    println UserUtils.cityOf(noUser)
}

class UserUtils {
    static String cityOf(User user) {
        user?.address?.city ?: "Unknown"
    }
}

/**
 * Einfache Model-Klassen
 */
class User {
    String name
    Address address
}

class Address {
    String city
}
