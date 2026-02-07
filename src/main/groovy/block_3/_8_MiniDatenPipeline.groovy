package block_3

import groovy.transform.Canonical
import groovy.transform.CompileStatic

/**
 * AUFGABE 3: Mini Data Pipeline & AST Transformations
 *
 * ZIEL:
 * Fortgeschrittene Groovy-Features wie AST-Transformationen (@Canonical), 
 * statische Kompilierung (@CompileStatic) und Closures im Methodenparameter anwenden.
 *
 * BESCHREIBUNG:
 * Gegeben ist eine Liste von Log-Zeilen. Diese sollen gefiltert, transformiert 
 * und in strukturierte Objekte überführt werden.
 *
 * ANFORDERUNGEN:
 * 1. Erstelle 'LogEntry' mit der passenden Annotation für automatische Konstruktoren/toString.
 * 2. Optimiere 'PipelineProcessor' für maximale Performance durch statische Typprüfung.
 * 3. Implementiere die 'process'-Methode:
 * - Sicherer Umgang mit null-Werten (Liste & Einträge).
 * - Filter: Nur Zeilen, die mit "INFO" beginnen.
 * - Transformation: Nutze die übergebene Closure für die Nachricht. Die erste Ausgabe soll so aussehen: "INFO [1]: GROOVY IST COOL". 
 * - Rückgabe: Eine Liste von 'LogEntry'-Objekten. ()
 * 4. Nutze in der 'main' GStrings für die finale Formatierung.
 */

static void main(String[] args) {
    println "--- AUFGABE 3: Pipeline mit AST & Closures ---"
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
            "", 
            "INFO: Das ist der letzte Eintrag"
    ]

    // TODO: Rufe PipelineProcessor.process auf.
    // Übergib die Liste und eine Closure, die den Text transformiert (wie der Counter funktioniert ist Ihnen überlassen).
    def result = [] // Implementiere den Aufruf hier

    println "Verarbeitete Ergebnisse:"
    result?.each { entry ->
        println entry
    }
}

/**
 * 1. TODO: Erstelle die Klasse LogEntry. 
 * Nutze hier eine AST-Transformation für automatische 
 * Konstruktoren und eine saubere toString()-Ausgabe 
 */


/**
 * 2. TODO: Erzwinge hier statische Typprüfung (Performance).
 */
class PipelineProcessor {

    /**
     * 3. TODO: Implementiere die Datenpipeline.
     * @param lines Die Liste der Rohdaten
     * @param transformLogic Eine Closure, die einen String transformiert
     */
    static List<LogEntry> process(List<String> lines, Closure<String> transformLogic) {
        // TODO: Implementiere die Logik. Achte auf null Einträge und nutze Closures für die verwendeten Methoden. 
        
        return [] // Platzhalter
    }
}