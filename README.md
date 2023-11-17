# Skill Booster

> Lernziele:
>- Java Klassen und Objekte
>- Klassenkonstruktoren und Initialisierung
>- Interfaces und abstrakte Klassen
>- Testen von Produktivcode mir Unit-Tests (JUnit)

Nachdem du die Java Basics kennengelernt hast tauchen wir in die Tiefen der Objektorientierten-Programmierung (OOP) ein.
Neben den Video Tutorials findest du in diesem Projekt Whitepapers die dich, beim Erlernen der OOP Prinziepien von Java,
unterstützen.

Als Übungsaufgabe ist in dieser Lerneinheit ein Projekt umzusetzen. Dieses Projekt deckt alle neuen Elemente des
Modulbausteins 002 001 ab.

# Projekt: Digitales Inventarverwaltungssystem

**Projektziel:**

Entwicklung eines ** Digitalen Inventarverwaltungssystems ** in Java. Das System soll die Verwaltung von
Inventarartikeln in einem Lager oder einer anderen Einrichtung ermöglichen. Die Interaktion mit dem System erfolgt über
die Kommandozeile.

**Kernanforderungen:**

**Benutzerfreundliche Kommandozeilen-Schnittstelle:**

Das Programm soll klare Anweisungen und Optionen für die
Benutzer bereitstellen, um verschiedene Aktionen wie das Hinzufügen, Entfernen, Suchen und Anzeigen von
Inventarartikeln durchzuführen.

**Klassenstruktur:**

- **Artikelklasse:** Repräsentiert einen Inventarartikel mit Eigenschaften wie ID, Name, Kategorie und Menge.
- **Kategorieklasse:** Repräsentiert verschiedene Kategorien von Artikeln.
- **Lagerverwaltungsklasse:** Verwaltet die Operationen im Inventar, wie das Hinzufügen und Entfernen von Artikeln.

**Interfaces:**

- **InventarOperationen:** Definiert grundlegende Operationen wie Hinzufügen, Entfernen, Suchen und Anzeigen von
  Artikeln.
- **BenutzerInteraktion:** Definiert die Interaktionen mit dem Benutzer über die Kommandozeile.

**Abstrakte Klassen:**

- **BasisArtikel:**
  Eine abstrakte Klasse, die gemeinsame Eigenschaften und Methoden für verschiedene Arten von
  Artikeln definiert.

**Funktionalitäten:**

- **Hinzufügen von Artikeln:** Ermöglicht es Benutzern, neue Artikel zum Inventar hinzuzufügen.
- **Entfernen von Artikeln:** Ermöglicht das Entfernen von Artikeln aus dem Inventar.
- **Suchen von Artikeln:** Ermöglicht die Suche nach Artikeln anhand verschiedener Kriterien.
- **Auflisten aller Artikel:** Zeigt alle Artikel im Inventar an.

**Datenpersistenz:**

- Optional kann eine einfache dateibasierte Speicherung implementiert werden, um die Inventardaten zwischen den
  Sitzungen zu erhalten. Schaue dir hierzu das Whitepapers
    - 002_001_json.pdf
    - 002_001_write_read_json_file.pdf
      an.
      Ein einfaches Beispiel findest du im Package 'schwarz.it.lws.howto.articlemanagement'
    -

**Dokumentation und Kommentare:**

- Jede Klasse, Methode und Schnittstelle sollte klar dokumentiert sein, um deren Zweck und Verwendung zu erklären. Du
  kannst dir die Arbeit hier sehr erleichtern, wenn du sprechende Bezeichner für Klassen, Methoden und Variablen
  verwendest.

**Testfälle:**

- Für jede Kernfunktionalität sollten einfache Testfälle erstellt werden, um die korrekte Funktionsweise
  des Systems zu gewährleisten. Test auch an den Kanten und nicht immer den Happy-Path, überlege hierbei welche
  Test-Szenarien die korrekte Funktion deines Testobjekts zu Ausnahmen oder falschen Ergebnissen führen können.

**Technische Anforderungen:**

- **Datenstruktur:** Nutzung von Collections für die Speicherung der Bücher.
- **Fehlerbehandlung:** Implementiere angemessene Fehlerbehandlung für Eingabe- und Verarbeitungsfehler.

**Zusätzliche Hinweise:**

- **Code-Stil:** Achte auf klaren, lesbaren und gut selbst dokumentierenden Code.
- **Modularität:** Der Code sollte modular aufgebaut sein, um Wartbarkeit und Erweiterbarkeit zu gewährleisten.

**Abschlusskriterien:**

Das Projekt gilt als erfolgreich abgeschlossen, wenn alle Kernanforderungen erfüllt sind und das System über die
Kommandozeile problemlos genutzt werden kann. Eine Demonstration des Systems, bei der alle Hauptfunktionen vorgeführt
werden, sollte Teil der Projektpräsentation sein. Am Ende der Woche wird zufällig ein Teinehmer benannt, der sein
Projekt kurz vorstellt. Es ist keine Präsentation mit PowerPoint zu erstellen, sondern es sollen nur die Funktion der
Applikation gezeigt werden.

Für dein Projekt "Digitales Inventarverwaltungssystem" schlage ich die folgende Paketstruktur vor, die auf deinen
den Anforderungen basiert und das Prinzip der klaren und logischen Organisation von Codepaketen berücksichtigt:

```
digitales_inventarverwaltungssystem                           <= Projektverzeichnis
 |__ src                                                      <= Source-Code Verzeichnis
 |    |__ main                                                
 |    |    |__ java                                           <= Programm-Code
 |    |        |__ schwarz.it.lws.inventorymanagement                  
 |    |        |    |__ model                                 <= Modelle (Datenstrukturen)
 |    |        |    |    |__ Item.java                        <= Artikelklasse (extend BasisItem)
 |    |        |    |    |__ Category.java                    <= Kategorieklasse
 |    |        |    |    |__ BaseItem.java                    <= BasisArtikel
 |    |        |    |                                         
 |    |        |    |__ exception                                         
 |    |        |    |    |__ ItemNotFoundException                                     
 |    |        |    |    |__ CategorieNotFoundException                                     
 |    |        |    |    |__ UnsuportedOperationException                                     
 |    |        |    |                                         
 |    |        |    |__ service                               <= Management-Logik
 |    |        |    |    |__ InventoryOperations.java         <= Lagerverwaltungs-Interface
 |    |        |    |    |__ InventoryManagementService.java  <= Lagerverwaltungsklasse (implement InventoryOperations)
 |    |        |    |                                     
 |    |        |    |__ InventoryManagementApp.java           <= BenutzerInteraktion
 |    |        |                                              
 |    |        |__ resources                                  <= Ressourcen (z.B. JSON Daten Datei)
 |    |                                                       
 |    |__ test                                                
 |         |__ java                                           <= Test-Code
 |             |__ schwarz.it.lws.inventorymanagement                  
 |                 |__ model                                  <= Model-Tests
 |                 |    |__ ItemTest.java                     
 |                 |    |__ CategoryTest.java                 
 |                 |    |__ BaseItemTest.java                 
 |                 |                                          
 |                 |__ management                             <= Management-Logik Tests
 |                 |    |__ InventoryManagementServiceTest.java         
 |                 |                                          
 |                 |__ InventoryManagementAppTest.java          
 |                                                            
 |__ pom.xml                                                  <= Maven Build-Konfiguration
 |__ README.md                                                <= README mit Projektinformationen
```

Diese Struktur folgt den Best Practices für Java-Projekte, wobei der Code in `main` und `test` unterteilt ist.
In `main/java` befinden sich die Hauptklassen, die in logische Unterpakete gegliedert sind:

- `model`: Enthält die Datenmodelle (`Item`, `Category`, `BaseItem`).
- `service`: Enthält die Klassen für die Verwaltungslogik (`InventoryManager`).
    - `InventoryOperations`: Definiert die Geschäftslogik und Operationen (`InventoryOperations Interface`).
- `cli`: Für die Benutzerschnittstelle über die Kommandozeile (`UserInteraction`).

Im `test`-Verzeichnis werden die entsprechenden Testklassen für jede Hauptklasse gespeichert. Diese Struktur unterstützt
eine klare Trennung der verschiedenen Aspekte deines Projekts und erleichtert die Wartung und das Testen.
