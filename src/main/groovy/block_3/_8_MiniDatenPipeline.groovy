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
 * - Transformation: Nutze die übergebene Closure für die Nachricht. Die erste Ausgabe soll so aussehen: "STAGE [1]: MIC CHECK 1-2". 
 * - Rückgabe: Eine Liste von 'RadioLog'-Objekten.
 * 4. Nutze in der 'main' GStrings für die finale Formatierung.
 */

static void main(String[] args) {
    println "--- AUFGABE 3: Festival-Pipeline mit AST & Closures ---"
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

    // TODO: Rufe PipelineProcessor.process auf.
    // Übergib die Liste und eine Closure, die den Text transformiert (wie der Counter funktioniert ist Ihnen überlassen).
    def result = [] // Implementiere den Aufruf hier

    println "Verarbeitete Funksprüche:"
    result?.each { logEntry ->
        println logEntry
    }
}

/**
 * 1. TODO: Erstelle die Klasse RadioLog. 
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
    static List<RadioLog> process(List<String> lines, Closure<String> transformLogic) {
        // TODO: Implementiere die Logik. Achte auf null Einträge und nutze Closures für die verwendeten Methoden. 
        
        return [] // Platzhalter
    }
}