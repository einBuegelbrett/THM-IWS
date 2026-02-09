package block_3

import groovy.transform.Canonical
import groovy.transform.CompileStatic

/**
 * LÖSUNG AUFGABE 3: Festival-Funk Pipeline & AST Transformations
 *
 * ZIEL:
 * Fortgeschrittene Groovy-Features (AST, CompileStatic, Closures) in einer Pipeline anwenden.
 */

// MUSTERLÖSUNG
static void main(String[] args) {
    println "--- LÖSUNG AUFGABE 3: Festival-Pipeline mit AST & Closures ---"
    println()

    // Simulierter Funkverkehr (Rohdaten)
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
    result.each { logEntry ->
        println logEntry
    }
}

/**
 * Modell-Klasse mit AST-Transformation.
 * Erzeugt automatisch Konstruktoren, toString, equals und hashCode.
 */
@Canonical
class RadioLog {
    String type
    String content
}

/**
 * Utility-Klasse mit statischer Typprüfung für maximale Performance.
 */
@CompileStatic
class PipelineProcessor {

    /**
     * Verarbeitet die Funksprüche.
     * Filtert nach "STAGE", bereinigt die Daten und wendet die Transformations-Logik an.
     */
    static List<RadioLog> process(List<String> lines, Closure<String> transformLogic) {
        if (lines == null) return []

        lines
            // 1. Filtern: Nur Stage-Events (Safe Navigation für null-Einträge)
            .findAll { String it -> it?.startsWith("STAGE") }
            
            // 2. Transformieren & Objekt-Erzeugung
            .collect { String line ->
                def parts = line.split(":")
                def type = parts[0].trim()
                def rawMsg = parts.size() > 1 ? parts[1].trim() : ""

                // Die übergebene Closure (transformLogic) wird hier ausgeführt
                def finalMsg = transformLogic(rawMsg)

                // Nutzt den von @Canonical generierten Konstruktor
                new RadioLog(type, finalMsg)
            }
    }
}