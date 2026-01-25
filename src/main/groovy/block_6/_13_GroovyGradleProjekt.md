# Block 6 – Mini-Projekt: Markdown → HTML

## Ziel
Baue ein kleines Groovy-Projekt, das mit Gradle Markdown-Dateien in HTML umwandelt.  
Dabei übst du Gradle Tasks, Dateiverarbeitung und Groovy-Closures.

---

## Projektstruktur
Erstelle folgende Ordner und Dateien:

## 📁 Projektstruktur

Dein Projekt soll am Ende folgende Struktur haben:

markdown-to-html/
├── build.gradle
├── settings.gradle
├── src/
│ └── main/
│ └── groovy/
│ └── MarkdownConverter.groovy
├── input/
│ └── example.md
└── output/

---

## Schritt 1: Projekt anlegen
Lege ein neues Verzeichnis an und erstelle eine `settings.gradle` mit dem Projektnamen `markdown-to-html`.

---

## Schritt 2: Gradle konfigurieren
In `build.gradle`:
- nutze das `groovy`-Plugin
- verwende `mavenCentral()`
- füge Groovy als Dependency hinzu
- erstelle einen Task `markdownToHtml`

---

## Schritt 3: MarkdownConverter
Implementiere eine Klasse `MarkdownConverter` mit einer Methode `convert(String text)`.  
Sie soll `#` zu `<h1>`, `##` zu `<h2>` und normalen Text zu `<p>` umwandeln.

---

## Schritt 4: Markdown-Datei
Lege im Ordner `input/` eine Datei `example.md` mit Überschriften und Text an.

---

## Schritt 5: Task ausführen
Führe im Projektverzeichnis aus:

```bash
gradle markdownToHtml
```

Der Task liest alle .md Dateien und erzeugt .html Dateien im Ordner output/.

## Bonus (optional)

Leere Zeilen ignorieren
### als <h3> unterstützen

Mehrere Markdown-Dateien verarbeiten