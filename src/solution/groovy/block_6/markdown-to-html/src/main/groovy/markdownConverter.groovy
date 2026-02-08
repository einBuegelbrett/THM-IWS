/*
Lösung mit einzelnen Zusatz-Features
convertLine, um jede Zeile auszuwerten
inline, um ** ** zu erkennen
*/

class MarkdownConverter {

    String convert(String text) {
        text.readLines()
            .findAll { it.trim() }               // leere Zeilen entfernen
            .collect { convertLine(it) }
            .join("\n")
    }

    private String convertLine(String line) {
        if (line.startsWith("### ")) {
            return "<h3>{inline(line.substring(4))}</h3>"
        }

        if (line.startsWith("## ")) {
            return "<h2>{inline(line.substring(3))}</h2>"
        }

        if (line.startsWith("# ")) {
            return "<h1>{inline(line.substring(2))}</h1>"
        }

        return "<p>${inline(line)}</p>"
    }

    private String inline(String text) {
        text
            .replaceAll(/\*\*(.+?)\*\*/, '<strong>$1</strong>')
            .replaceAll(/\*(.+?)\*/, '<em>$1</em>')
    }
}

def converter = new MarkdownConverter()

def input = """
# Titel
Ein **Absatz**
## Untertitel
Noch *ein* Text
"""

println converter.convert(input)
