package block_3

/**
 * Aufgabe 6:
 * Erstelle eine Klasse `Person` mit folgenden Eigenschaften und Methoden:
 *
 * Eigenschaften:
 * - Vorname (String)
 * - Nachname (String)
 * - Alter (Integer)
 *
 * Methoden:
 * - `fullName()` gibt den vollständigen Namen im Format "Vorname Nachname" zurück
 * - `isAdult()` gibt `true` zurück, wenn die Person volljährig ist (Alter >= 18)
 * - `description()` gibt eine lesbare Beschreibung im Format "Vorname Nachname (Alter Jahre)" zurück
 */
static void main(String[] args) {

    println "Aufgabe Person"
    println()

    def person1 = new Person(
            firstName: "Max",
            lastName : "Mustermann",
            age      : 25
    )

    def person2 = new Person(
            firstName: "Lisa",
            lastName : "Müller",
            age      : 16
    )

    println "Person 1:"
    println person1.fullName()
    println "Volljährig: ${person1.isAdult()}"
    println person1.description()
    println()

    println "Person 2:"
    println person2.fullName()
    println "Volljährig: ${person2.isAdult()}"
    println person2.description()
}

class Person {

    String firstName
    String lastName
    Integer age

    /**
     * Gibt den vollständigen Namen zurück
     * z.B. "Max Mustermann"
     */
    String fullName() {
        "${firstName} ${lastName}"
    }

    /**
     * Prüft, ob die Person volljährig ist (>= 18)
     */
    boolean isAdult() {
        age >= 18
    }

    /**
     * Gibt eine lesbare Beschreibung zurück
     * z.B. "Max Mustermann (25 Jahre)"
     */
    String description() {
        "${fullName()} (${age} Jahre)"
    }
}
