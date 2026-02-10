package block_3


static void main(String[] args) {
    println "--- Musterlösung-Aufgabe 2: Ranges, Spread & DSL ---"

    def users = [
        new EventUser(name: "Joe", ticketId: 50),
        new EventUser(name: "Bob", ticketId: 150), // Ungültig
        new EventUser(name: "Jacqueline", ticketId: 10),
        null // Härtetest für Safe Navigation
    ]

    // DSL-Style: Klammern weglassen beim Aufruf
    println "Alle Namen im System:"
    println EventUtils.allNames(users) 

    println "\nVIP-Status Check (Tickets 1-50):"
    println EventUtils.getVipStatusList(users)
}

class EventUtils {
    // Nutzt den Spread-Operator (*.), der null-safe arbeitet
    // Ersetzt null-Namen durch "kein Name"
    // Liefert eine leere Liste zurück, falls users null ist
    static List<String> allNames(List<EventUser> users) {
        users*.name.collect { it ?: "kein Name" } ?: []
    }

static List<String> getVipStatusList(List<EventUser> users) {
    // VIP-Ticketnummern von 1 bis 50
    def vipRange = 1..50

    // Falls users null ist, mit leerer Liste arbeiten
    (users ?: []).collect { u ->
        // Name sicher lesen, null → "Gast"
        def name = u?.name ?: "Gast"
        // Ticket-ID sicher lesen, null → 0 (kein VIP)
        def id   = u?.ticketId ?: 0

        // VIP-Check mit Range und GString
        "${name} ist " + ((id in vipRange) ? "ein VIP" : "kein VIP")
    }
}

}

class EventUser {
    String name
    Integer ticketId
}