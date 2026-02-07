package block_3

import groovy.transform.Canonical
import groovy.transform.CompileStatic

/**
 * Aufgabe: High-Performance Data Pipeline & AST Transformations
 *
 * Ziel der Übung:
 * Fortgeschrittene Groovy-Features wie AST-Transformationen, statische Kompilierung 
 * und Higher-Order Functions in einer Pipeline anwenden.
 *
 * Beschreibung:
 * Gegeben ist eine Liste von Textzeilen. Diese sollen gefiltert, transformiert 
 * und in strukturierte Objekte überführt werden.
 *
 * Anforderungen:
 * 1. Nutze @Canonical für das Datenmodell 'LogEntry', um Boilerplate-Code zu sparen.
 * 2. Nutze @CompileStatic für die 'PipelineProcessor'-Klasse für maximale Performance.
 * 3. Implementiere 'process', sodass eine Closure als Transformations-Logik akzeptiert wird.
 * 4. Filter nur "INFO"-Zeilen (beachte null-Einträge mit Safe Navigation ?.).
 * 5. Verwende GStrings für die finale Formatierung der Nachricht.
 */


// MUSTERLÖSUNG
static void main(String[] args) {
    println "--- Aufgabe: Pipeline mit AST & Closures ---"
    println()

    // Simulierte Datei
    def lines = [
            "INFO: Groovy ist cool",
            "DEBUG: Suche nach Fehlern...",
            "INFO: Workshop macht Spaß",
            "ERROR: Verbindung verloren",
            null,
            "INFO: Kaffee-Pause einlegen",
            "DEBUG: Cache geleert",
            "INFO: Fast fertig mit der Aufgabe",
            "WARN: Speicher fast voll",
            "INFO: Lernen ist toll",
            "", // Leere Zeile zum Testen der Robustheit
            "INFO: Das ist der letzte Eintrag"
    ]

    def counter = 1
    // Aufruf der Pipeline mit einer Closure als Parameter (Higher-Order Function)
    // Hier definieren wir ad-hoc, wie die Nachricht transformiert werden soll
    def result = PipelineProcessor.process(lines) { String msg ->
        "INFO [${counter++}]: ${msg.toUpperCase()}"
    }

    println "Verarbeitete Ergebnisse:"
    result.each { entry ->
        // Dank @Canonical wird hier eine saubere toString-Repräsentation ausgegeben
        println entry
    }
}

/**
 * Modell-Klasse mit AST-Transformation
 */
@Canonical
class LogEntry {
    String level
    String message
}

/**
 * Utility-Klasse mit statischer Typprüfung
 */
@CompileStatic
class PipelineProcessor {

    /**
     * Verarbeitet die Zeilen. Akzeptiert eine Liste und eine Closure für die Transformation.
     */
    static List<LogEntry> process(List<String> lines, Closure<String> transformLogic) {
        if (lines == null) return []

        lines
            // 1. Filtern (Safe Navigation für null-Einträge)
            .findAll { String it -> it?.startsWith("INFO") }
            
            // 2. Transformieren & Objekt-Erzeugung
            .collect { String line ->
                def parts = line.split(":")
                def level = parts[0].trim()
                def rawMessage = parts[1].trim()

                // Die übergebene Closure wird ausgeführt
                def finalMessage = transformLogic(rawMessage)

                // Nutzt den von @Canonical generierten Konstruktor
                new LogEntry(level, finalMessage)
            }
    }
}