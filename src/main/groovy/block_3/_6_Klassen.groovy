package block_3

/**
 * AUFGABE 1: Der Festival-Groover
 * * ZIEL:
 * Kennenlernen von Groovy-Klassen, GStrings und der vereinfachten Methoden-Syntax.
 * * ANFORDERUNGEN:
 * 1. Implementiere 'vibeStatus': Nutze GStrings für die Ausgabe.
 * 2. Implementiere 'isReadyToParty': Nutze den Implizit Return (kein 'return' nötig).
 * 3. Implementiere 'festivalCard': Kombiniere Methodenaufrufe innerhalb eines GStrings.
 *
 * Für die groovierenden unter euch: löst jede Aufgabe mit nur einer einzigen Zeile und wenn möglich nur mit einem String. 
 */
static void main(String[] args) {

    println "--- Aufgabe 1: Festival Check-In ---"
    println()

    def groover1 = new Groover(
            stageName: "Jimi",
            instrument: "E-gitarre",
            vibeLevel: 90,
            setlist: ["Voodoo Child", "Hey Joe"]
    )

    def groover2 = new Groover(
            stageName: "Bob",
            instrument: "Luftgitarre",
            vibeLevel: 45,
            setlist: ["Purple Haze", "Amazing Green"]
    )

    println "Groover 1:"
    println groover1.vibeStatus()
    println "Bereit für Moshpit: ${groover1.isReadyToParty()}"
    println groover1.festivalCard()
    println "Anzahl Songs auf der Setlist: ${groover1.countSongs()}"
    println "Erster Song: ${groover1.getOpeningSong()}"
    println()

    println "Groover 2:"
    println groover2.vibeStatus()
    println "Bereit für Moshpit: ${groover2.isReadyToParty()}"
    println "Anzahl Songs auf der Setlist: ${groover2.countSongs()}"
    println "Erster Song: ${groover2.getOpeningSong()}"
    println groover2.festivalCard()
}

class Groover {

    String stageName
    String instrument
    Integer vibeLevel
    List<String> setlist = []

    /**
     * Gebe den Namen inkl. das Instrument zurück. Achte dabei auf GStrings.  
     * z.B. "Jimi rockt die Stratocaster"
     */
    String vibeStatus() {
        "" 
    }

    /**
     * Prüfe, ob das vibeLevel hoch genug für die Party ist (>= 80)
     * Implementiere den Check (Implizit Return nutzen!)
     */
    boolean isReadyToParty() {
        false 
    }

    /**
     * Gebe den vibeStatus mit dem Vibe-Level zurück und benutze GStrings. 
     * z.B. "Jimi rockt die Stratocaster (Vibe: 90%)"
     */
    String festivalCard() {
        ""
    }


    /**
     * Erstelle eine Rückgabe für den ersten Song
     * z.B. "Blue Grooved" als erster Song 
     */
    String getOpeningSong() {
        ""
    }

    /**
     * Gebe die Anzahl aller Songs zurück. 
     * z.B. "Blue Grooved" als erster Song 
     */
    int countSongs() {
            ""
    }
}