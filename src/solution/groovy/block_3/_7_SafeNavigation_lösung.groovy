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
    // 1. Nutze Safe Navigation und den Spread-Operator (*.)
    // 2. Erstelle eine Range von 1 bis 50 für VIPs
    static List<String> allNames(List<EventUser> users) {
        // TIPP: users?.name gibt dir direkt eine Liste der Namen, 
        // aber Vorsicht mit den Null-Einträgen in der Liste!
        users?.findAll { it != null }*.name ?: []
    }

static List<String> getVipStatusList(List<EventUser> users) {
        List<String> results = []
        
        // 1. SPREAD-OPERATOR & SAFE NAVIGATION
        // Wir holen uns alle Namen vorab als Liste (ignoriert null-User dank ?. und *.)
        def allNames = allNames(users)
        
        // 2. RANGE & ELVIS-OPERATOR
        def vipRange = 1..50
        // Sicherstellen, dass wir eine Liste haben, selbst wenn users null ist
        def safeUsers = users ?: [] 

        // 3. FOR-SCHLEIFE MIT GSTRINGS
        for (user in safeUsers) {
            // SAFE NAVIGATION beim Zugriff auf ticketId
            def id = user?.ticketId ?: 0 // Elvis: Falls null (z.B. bei null-User), nimm 0
            
            // RANGE-CHECK mit 'in'
            if (id in vipRange) {
                // GSTRING mit Safe Navigation für den Namen
                results.add("${user?.name ?: 'Gast'} ist VIP")
            } else if (user != null) {
                results.add("${user.name} ist kein VIP")
            }
        }
        
        return results
    }
}

class EventUser {
    String name
    Integer ticketId
}