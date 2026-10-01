# DiskScope

JavaFX-Anwendung zur Analyse der Speicherplatzbelegung. DiskScope scannt ein Verzeichnis rekursiv und zeigt, wo der Speicherplatz tatsächlich liegt: größte Dateien, Verteilung nach Dateityp und Größe je Unterordner. Der Scan läuft nebenläufig im Hintergrund, die Oberfläche bleibt währenddessen bedienbar.

## Funktionen

- Rekursiver Scan eines Verzeichnisbaums, wahlweise sequenziell oder parallel
- Top-N der größten Dateien, Größe je Dateiendung, Größe je Unterordner
- Live-Fortschrittsanzeige während des Scans
- Sortierung der Ergebnisse nach Größe, Name oder Dateianzahl
- Export als CSV oder TXT
- Speichern und Laden eines Scan-Ergebnisses, damit lange Scans nicht wiederholt werden müssen

## Starten

```bash
git clone https://github.com/itsChesterfield/diskscope.git
cd diskscope
mvn javafx:run
```

Voraussetzungen: JDK 21 oder neuer, Maven 3.9+.

## Verwendete Konzepte

Jede eingesetzte Technik löst in diesem Projekt ein konkretes Problem:

| Problem | Lösung |
| --- | --- |
| Ein Scan über viele tausend Dateien dauert zu lange | Unterbäume werden parallel über einen `ExecutorService` verarbeitet, Teilergebnisse über `Future` eingesammelt |
| Die Oberfläche soll während des Scans bedienbar bleiben | Der Scan läuft außerhalb des JavaFX-Threads, Oberflächen-Updates über `Platform.runLater` |
| Das Modell soll nichts über die Oberfläche wissen | Fortschritt wird über `PropertyChangeSupport` gemeldet, der Controller meldet sich als Listener an |
| Mehrere Exportformate ohne Fallunterscheidung im Controller | Fester Ablauf in `AbstractExporter` (Template Method), Erzeugung über `ExporterFactory` (Abstract Factory) |
| Auswertungen ohne verschachtelte Schleifen | Stream-basierte Aggregation mit `groupingBy` und `mapToLong`, dazu eine eigene generische `TopNList<T>` |
| Lange Scans nicht wiederholen müssen | Serialisierung des Ergebnisbaums |

## Projektstruktur

```
diskscope.model      Datenmodell des Verzeichnisbaums, Scan-Zustand
diskscope.scan       Scanner-Interface, sequenzielle und parallele Implementierung
diskscope.analyse    Auswertungen, TopNList, Sortierkriterien
diskscope.export     Exporter, Template Method, Factory
diskscope.ui         FXML-View und Controller
```

## Tests

```bash
mvn test
```

Die Analyse-Tests arbeiten gegen einen im Speicher aufgebauten Verzeichnisbaum statt gegen das echte Dateisystem und laufen dadurch unabhängig vom ausführenden Rechner. Die Benachrichtigung der Listener wird mit Mockito geprüft.

## Lizenz

MIT
