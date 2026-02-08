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

    // TODO: rufe beide Methoden auf und geben sie mit passenden Überschriften aus. Achte auf den DSL-Style. 

}

class EventUtils {

    /**
     * Extrahiert alle Namen aus der User-Liste.
     * Nutze Safe Navigation und den Spread-Operator.
     */
    static List<String> allNames(List<EventUser> users) {
        // Die Methode hat idealerweise einen Inhalt von genau einer Zeile. 
        // TODO: Gib eine leere Liste zurück, falls 'users' null ist (Elvis Operator)
        
        [] // Platzhalter
    }

    /**
     * Prüft das Ticket des ersten Users in der Liste.
     */
    static String getVipStatus(List<EventUser> users) {
        // TODO: Entnehme alle User aus der vorherigen Methode  
        // TODO: Erstelle eine Range von 1 bis 50, prüfe das die Userliste nicht null ist. 
        // TODO: Prüfe mit dem 'in' Operator in einer For-Schleife, ob die ticketId in der Range liegt
        //       Nutze dafür den Elvis-Operator, Safe Navigation und GStrings.  
        
        return "Noch nicht implementiert"
    }
}

class EventUser {
    String name
    Integer ticketId
}