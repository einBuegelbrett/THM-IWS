package block_3

/**
 * AUFGABE 2: Ticket-Validierung & VIP-Check
 * * ZIEL:
 * Vertiefung von Ranges, dem Spread-Operator, Safe Navigation und dem DSL-Style.
 * * ANFORDERUNGEN:
 * 1. Implementiere 'allNames': Nutze den Spread-Operator (*.), um alle Namen zu extrahieren.
 * 2. Achte auf null-Einträge in der Liste (Safe Navigation nutzen!).
 * 3. Implementiere 'getVipStatus': Nutze eine Range (1..50), um den VIP-Status zu prüfen.
 * 4. Nutze den DSL-Style, wo es in Groovy üblich ist.
 */

static void main(String[] args) {
    println "--- Aufgabe 2: Ranges, Spread & DSL ---"

    def users = [
        new EventUser(name: "Joe", ticketId: 50),
        new EventUser(name: "Bob", ticketId: 150), 
        new EventUser(name: "Jacqueline", ticketId: 10),
        null 
    ]

    // DSL-Style: Klammern weglassen beim Aufruf
    println "Alle Namen im System:"
    println EventUtils.allNames(users) 

    println "\nVIP-Status Check (Tickets 1-50):"
    println EventUtils.getVipStatusList(users)
}

class EventUtils {

    /**
     * Extrahiert alle Namen aus der User-Liste.
     * Nutze den Spread-Operator für alle Namen inkl. Null 
     * Nutze .collect, um mit dem Elvis-Operator "kein Namen" zurückzugeben
     * Bei keinem User, leere Liste zurückgeben. 
     * PS: Es gibt mehrere Möglichkeiten, das zu lösen. 
     */
    static List<String> allNames(List<EventUser> users) {       
        [] // Platzhalter
    }

    /**
     * Erstelle eine Range von 1 bis 50. Wenn es keinen User gibt -> leere Liste
     * Nutze .collect um den Namen (auch bei Null!!) sicher zu lesen.
     * Prüfe ob die Ticket_ID gültig in der Range ist! (bei Null -> 0)
     * Nutze GStrings und Elvis für VIP und nicht VIP-user. 
     */
    static List<String> getVipStatusList(List<EventUser> users) {
        return "Noch nicht implementiert"
    }
}

class EventUser {
    String name
    Integer ticketId
}