package block_3

import groovy.transform.Canonical
import groovy.transform.CompileStatic

/**
 * AUFGABE 3: Festival-Funk & AST Transformations
 *
 * ZIEL:
 * Fortgeschrittene Groovy-Features wie AST-Transformationen (@Canonical), 
 * statische Kompilierung (@CompileStatic) und Closures im Methodenparameter anwenden.
 *
 * BESCHREIBUNG:
 * Gegeben ist eine Liste von Funksprüchen aus dem Backstage-Bereich. Diese sollen gefiltert, 
 * transformiert und in strukturierte 'RadioLog' Objekte überführt werden.
 *
 * ANFORDERUNGEN:
 * 1. Erstelle 'RadioLog' mit der passenden Annotation für automatische Konstruktoren/toString.
 * 2. Optimiere 'PipelineProcessor' für bessere Performance durch statische Typprüfung.
 * 3. Implementiere die 'process'-Methode:
 * - Sicherer Umgang mit null-Werten (Liste & Einträge).
 * - Filter: Nur Funksprüche, die mit "STAGE" beginnen.
 * - Transformation: Nutze die übergebene (!!!) Closure für die Nachricht. Die erste Ausgabe soll so aussehen: "STAGE [1]: MIC CHECK 1-2". 
 * - Rückgabe: Eine Liste von 'RadioLog'-Objekten.
 * 4. Nutze in der 'main' GStrings für die finale Formatierung.
 */

static void main(String[] args) {
    println "--- Aufgabe 3: Festival-Pipeline mit AST & Closures ---"
    println()

    // Simulierter Funkverkehr
    def messages = [
            "STAGE: Mic Check 1-2",
            "SECURITY: Eingang West überfüllt",
            "STAGE: Gitarre von Slash stimmen",
            "CATERING: Pizza für Backstage ist da",
            null,
            "STAGE: Nebelmaschine auffüllen",
            "SECURITY: Moshpit wird wild",
            "STAGE: Monitor-Mix anpassen",
            "VIP: Champagner ist leer",
            "STAGE: Show startet in 5 Minuten",
            "", 
            "STAGE: Pyrotechnik bereit"
    ]

    def radioCounter = 1
    
    /**
     * Aufruf der Pipeline:
     * Wir filtern nur "STAGE"-Sprüche und transformieren sie in Großbuchstaben mit Nummerierung.
     */
    def result = PipelineProcessor.process(messages) { String msg ->
        "STAGE [${radioCounter++}]: ${msg.toUpperCase()}"
    }

    println "Verarbeitete Funksprüche:"
    result?.each { logEntry ->
        println logEntry
    }
}

/**
 * TODO: Erstelle die Klasse RadioLog. 
 * Nutze hier eine AST-Transformation für automatische 
 * Konstruktoren und eine saubere toString()-Ausgabe 
 * Die Klasse braucht nur zwei Strings (type und content), mehr nicht. 
 */


/**
 * TODO: Erzwinge hier statische Typprüfung (Performance).
 */
class PipelineProcessor {

    /**
     * TODO: Implementiere die Datenpipeline.
     * @param lines Die Liste der Rohdaten
     * @param transformLogic Eine Closure, die einen String transformiert
     */
    static List<RadioLog> process(List<String> lines, Closure<String> transformLogic) {
        // TODO: Implementiere die Logik. 
        // Achte auf null Einträge und nutze Closures für die verwendeten Methoden.
        // Gebe bei keinen Lines eine leere Liste zurück. 
        // Siehe oben die Anforderungen (Tipp: Nutze Closures in .findAll und .collect)
        
        return [] // Platzhalter
    }
}