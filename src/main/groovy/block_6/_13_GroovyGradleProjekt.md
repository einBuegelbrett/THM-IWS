# Block 6 – Mini-Projekt: Markdown → HTML

## Ziel
Baue ein kleines Groovy-Projekt, das mit Gradle Markdown-Dateien in HTML umwandelt.  
Dabei übst du Gradle Tasks, Dateiverarbeitung und Groovy-Closures.

Let’s make your build script dance. 🕺

---

## Projektstruktur
Dein Projekt soll am Ende folgende Struktur haben (aka: dein persönlicher Dancefloor):
```
markdown-to-html/  
├── build.gradle  
├── settings.gradle  
├── src/  
│ └── main/  
│    └── groovy/  
│       └── MarkdownConverter.groovy  
├── input/  
│ └── example.md  
└── output/
```

---

## Schritt 1: Projekt anlegen
Projektname: markdown-to-html

Projekt erstellen:
```bash
gradle init --type groovy-application --dsl groovy
```

---

## Schritt 2: build.gradle vorbereiten
Stelle sicher:
- Plugin: groovy
- Repository: mavenCentral()
- Dependency: Groovy
- Neuer Task: markdownToHtml

---

## Schritt 3: MarkdownConverter
Implementiere eine Klasse `MarkdownConverter` mit einer Methode `static String convert(String text)`.  
Sie soll `#` zu `<h1>`, `##` zu `<h2>` und normalen Text zu `<p>` umwandeln.
Der erzeugte HTML-Code muss zusätzlich in folgende Grundstruktur eingebettet werden: `<!DOCTYPE html><html><body> … </body></html>`.

---

## Schritt 4: Markdown-Datei
Lege im Ordner `input/` eine Datei `example.md` mit Überschriften und Text an.

Beispiel:
```
# Stayin' Alive
## Daddy Cool
Ich liebe "Le Freak" von CHIC  
```

---

## Schritt 5: Gradle Task
Erstelle einen eigenen Gradle-Task mit dem Namen: markdownToHtml

Der Task soll:
- alle .md Dateien aus dem Ordner input/ einlesen
- den Inhalt jeder Datei laden
- den Text mit MarkdownConverter.convert(text) umwandeln
- für jede Datei eine .html Datei erzeugen
- den output/ Ordner erstellen, falls er noch nicht existiert
- die HTML-Dateien im Ordner output/ speichern

```bash
gradle markdownToHtml
```

## Schritt 6: Projekt ausführen & Ergebnis prüfen
Task ausführen
```
./gradlew markdownToHtml
```

Viel Erfolg! https://www.youtube.com/watch?v=dQw4w9WgXcQ&list=RDdQw4w9WgXcQ&start_radio=1

## Bonus (optional)
- Leere Zeilen ignorieren
- \### als <h3> unterstützen
- Mehrere Markdown-Dateien verarbeiten
- Lagere deine Konvertierungslogik in eine eigene Library aus.
- Erweitere den Logging (Gib aus, welche Datei gerade verarbeitet wird, Zeige an, wie viele Dateien konvertiert wurden, ...)