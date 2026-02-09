# Aufgabenstellung: Build Your Own Groovy Groove Library 🕺

## Ziel der Aufgabe
In dieser Aufgabe entwickeln ihr nun eine **eigene Groovy-Library**. 

Let’s get your code into the groove! 

---

## Teil 1: Neue Library erstellen
Erstellt ein neues Gradle-Projekt mit dem Namen:

```
groove-library
```

Dieses Projekt stellt Ihre **selbst entwickelte Library** dar.

### build.gradle (Grundstruktur)

```gradle
plugins {
    id 'groovy'
    id 'maven-publish'
}

group = 'de.thm'
version = '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.apache.groovy:groovy:5.0.0'
}
```

---

## Teil 2: Externe Dependency einbinden
Eure Library soll zusätzlichen Groove von außen bekommen.

Bindet eine **externe Library** ein:
https://mvnrepository.com/artifact/org.apache.commons/commons-lang3

---

## Teil 3: Groove-Klasse implementieren
Erstellt eine Groovy-Datei "GrooveGenerator.groovy":

### Anforderungen
Die Klasse soll mindestens **zwei statische Methoden** besitzen.

Mindestens **eine Methode muss die externe Dependency verwenden**:

https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/RandomStringUtils.html#randomAlphanumeric(int)

```groovy
RandomStringUtils.randomAlphanumeric(6)
```

---

## Teil 4: Library lokal veröffentlichen
Konfiguriert das Publishing. Lasst euch dabei von den Boogie Moves des anderen Projekts inspirieren.

Veröffentlichen:
```bash
./gradlew publishToMavenLocal
```

Damit wird eure Library in euer lokales Maven-Repository „gedroppt“ 🎶

---

## Teil 5: Library verwenden
Ihr fügt die Abhängigkeit in der allgemeinen build.gradle hinzu und benutzt die Library hier:
```
src/main/groovy/block_5/_11_Dependencies_undLibraries/GroovyLibrary.groovy
```

Beim Ausführen sollte euer Programm nun grooven 🕺

---

**Stay Groovy and keep your code in rhythm 🎶**
