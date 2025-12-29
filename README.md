# THM-IWS
## Block 1: Einführung und Motivation (30 Min.)
### Theorie (25 Min.)
- Was ist Groovy? Warum wurde es entwickelt
- Projektbeispiele: Gradle, Jenkins-Pipelines, Spock
- Rolle von Groovy in Gradle
- allgemeiner Vergleich Groovy vs Java
- Ziele des Workshops
  - Grundlagen von Groovy/Gradle kennenlernen
  - Projektstruktur von Gradle
  - Stärken vs. Schwächen Groovy

### Mini-Praxis (5 Min.)
- Jeder führt print("Hello World") aus
- Kurzer Check der Umgebung

## Block 2: Groovy Grundlagen I (50 Min.)
### Theorie (15 Min.)
- Dynamische vs statische Typisierung
- Syntax-Vergleich Groovy vs Java
- Listen, Maps
- Closures
- Kontrollstrukturen

### Praxis (30 Min.)
Kleine Aufgaben-Folge:
1. Liste filtern (Closures)
2. Map transformieren
3. Eine kleine Funktion mit Default-Parametern
4. Textanalyse (z. B. Wortanzahl)

## Block 3: Groovy Grundlagen II (50 Min.) 
### Theorie (10 Min.)
- Klassen in Groovy (tbd)
- Groovy-spezische Features (Ranges, Safe Navigation, GStrings)

### Praxis (35 Min.)
1. Einfache Klasse modellieren
2. Safe-Navigation -> Nullpointer-Übung
3. Aufgabe "Mini-Datenpipeline":
   - Datei einlesen
   - Zeilen ltern
   - transformieren
   - Ergebnis ausgeben

**Ziel**: Umgang mit Strings, Closures, Collections vertiefen

## Block 4: Gradle Theorie (45 Min.)
### Theorie (30 Min.)
- Was ist Gradle?
- Wie nutzt Gradle Groovy?
- Vergleich Gradle vs. Maven
- Aufbau einer build.gradle Datei
- Gradle Tasks & Lifecycle
- Plugins, Dependencies, Repositories
- Warum Groovy für DSLs gut geeignet ist

### Praxis-Demo (15 Min.)
- Kurze Live-Demo: Build starten
- Zeigt gradle tasks, gradle dependencies
- Erklärt, wie Groovy-Closures im Gradle DSL wirken

## Block 5: Gradle Praxis I (45 Min.)
Großer praktischer Block

**Aufgaben:**
1. Buildskript lesen
   - Was tut das Skript?
   - Welche Plugins? Welche Tasks?
   - Wo ist Groovy sichtbar?
2. Eigener Task
   - task mytask {doLast(...)}
   - ausführen, debuggen 
3. (Task mit Parametern/Closure)
   - Liste ausgeben
   - Datei generieren
4. Build-Fehler beheben
   - Absichtlich fehlerhafte build.gradle
   - Syntax-, Dependecy- oder oder Plugin-Fehler finden

## Block 6: Gradle Praxis II (60 Min.)
Mini-Projekt:
- Ein kleines Groovy-Projekt wird gebaut
- mit Gradle build