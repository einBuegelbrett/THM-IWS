package block_3

/**
 * LÖSUNG AUFGABE 1: Der Festival-Groover
 * * ZIEL: 
 * Klassen-Basics, GStrings und Kurzschreibweisen.
 */
static void main(String[] args) {

    println "--- Aufgabe 1: Festival Check-In ---"
    println()

    // Dank Groovy können wir Map-Style Konstruktoren nutzen!
    def groover1 = new Groover(
            stageName: "Jimi",
            instrument: "Stratocaster",
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
     * Nutzt GStrings zur Verkettung.
     * In Groovy ist kein 'return' nötig, das letzte Statement zählt.
     */
    String vibeStatus() {
        "$stageName rockt die $instrument" 
    }

    /**
     * Einfacher Vergleich. Das Ergebnis (boolean) wird automatisch zurückgegeben.
     */
    boolean isReadyToParty() {
        vibeLevel >= 80 
    }

    String getOpeningSong() {
        setlist ? setlist[0] : "Noch keine Songs"
    }

    int countSongs() {
            setlist.size()
        }
    /**
     * Kombination aus Methodenaufruf und Variable innerhalb eines GStrings.
     */
    String festivalCard() {
        "${vibeStatus()} (Vibe: $vibeLevel%)"
    }
}