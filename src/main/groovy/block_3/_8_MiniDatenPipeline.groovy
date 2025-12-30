package block_3

/**
 * Aufgabe Mini-Datenpipeline
 *
 * Ziel der Übung:
 * Arbeiten mit Collections, Closures und GStrings in Groovy.
 *
 * Beschreibung:
 * Gegeben ist eine Liste von Textzeilen (simulierte Datei).
 * Implementiere eine einfache Datenpipeline mit folgenden Schritten:
 *
 * 1. Filter alle Zeilen, die mit "INFO" beginnen (beachte, dass einzelne Einträge `null` sein können)
 * 2. Extrahiere aus jeder gefilterten Zeile die eigentliche Nachricht (Text nach dem Doppelpunkt)
 * 3. Transformiere jede Nachricht in eine neue Zeichenkette im Format: "✔ NACHRICHT"
 *
 * Anforderungen:
 * - Verwende Safe Navigation (?.), um NullPointerExceptions zu vermeiden
 * - Verwende GStrings für die String-Erzeugung
 * - Nutze Closures zur Filterung und Transformation
 */

static void main(String[] args) {

    // Simulierte Datei
    def lines = [
            "INFO: Groovy ist cool",
            "DEBUG: Details",
            "ERROR: Etwas ging schief",
            null,
            "INFO: Lernen ist toll"
    ]

    println "Aufgabe Mini-Datenpipeline"
    println()

    def result = MiniPipeline.process(lines)

    println "Ergebnis:"
    result.eachWithIndex { entry, i ->
        println "${i + 1}. ${entry}"
    }
}


class MiniPipeline {
    static List<String> process(List<String> lines) {
        if (lines == null) {
            return []
        }

        // Mini-Datenpipeline
        lines
        // 1. Filtern (Safe Navigation)
            .findAll { it?.startsWith("INFO") }

        // 2. Transformieren
            .collect { line ->
                def message = line.split(":")[1].trim()
                "✔ ${message.toUpperCase()}".toString()   // GString
            }
    }
}
