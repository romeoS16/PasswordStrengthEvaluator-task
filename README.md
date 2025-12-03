# Aufgabe – PasswordStrengthEvaluator (Gruppe C – TDD + KI)

In dieser Aufgabe üben Sie **Test-Driven Development (TDD)** und dürfen zusätzlich eine KI
(z.B. ChatGPT) unter klar definierten Bedingungen verwenden.  

---

## Aufgabe

Implementieren Sie in der Klasse [PasswordStrengthEvaluator](src/main/java/de/ba/experiment/PasswordStrengthEvaluator.java) die Methode

```java
public static String evaluateStrength(String password){}
```

Die Methode soll entweder "WEAK", "MEDIUM" oder "STRONG" als String zurückgeben.

**Für diese Aufgabe gilt:**  
(1) Ungültiges Passwort
- Wenn das passwort null, leer oder ein Leerzeichen enthält, soll direkt der String "WEAK" zurückgegeben werden.

(2) Basisanforderung an die Länge
- Wenn die Länge < 6 entspricht, soll ebenfalls der String "WEAK" zurückgegeben werden.

(3) Kriterien für Stärke
Es werden folgende Eigenschaften geprüft:
- hat mindestens einen Kleinbuchstaben [a-z]
- hat mindestens einen Großbuchstaben [A-Z]
- hat mindestens eine Ziffer [0-9]
- hat mindestens ein Sonderzeichen (nicht Buchstabe und nicht Ziffer)
- hat Länge >= 10

Für jede erfüllte Eigenschaft gibt es 1 Punkt.

(4) Auswertung
- Punkte <= 2  -> "WEAK"
- Punkte == 3  -> "MEDIUM"
- Punkte >= 4  -> "STRONG"

(5) Beispiele
- null -> "WEAK"
- Abc123 -> "MEDIUM"
- aaaAAAbbb!223j -> "STRONG"


Schreiben Sie Tests in der [PasswordStrengthEvaluatorTest](src/test/java/PasswordStrengthEvaluatorTest.java) Klasse.

---

## Vorgehen (TDD: Red – Green – Refactor)

Grundsätzlich arbeiten Sie wie in Gruppe B:

(1) **Red** – Test schreiben
- Schreiben Sie zuerst eigene Testfälle in PasswordStrengthEvaluatorTest

(2) **Green** – minimaler Code
- Implementieren Sie evaluateStrength(...) so, dass Ihre Tests grün werden.

(3) **Refactor** – aufräumen
- Verbessern Sie Code und ggf. Tests, ohne das Verhalten zu ändern.

(4) Ergänzen Sie nach und nach weitere Tests

---

## Nutzung von KI

Sie dürfen eine KI (z.B. ChatGPT) zur Unterstützung einsetzen – aber nur nach bestimmten Regeln:

(1) Zuerst eigene Tests, dann KI
- Die Tests werden in jedem Fall zuerst von den Studierenden **selbst** geschrieben
- Erst danach ist KI erlaubt:

(2) Wofür Sie KI verwenden dürfen
- Ideen für eine saubere Implementierung (z.B. Vorverarbeitung des Strings, Schleifenlogik)
- Refactoring-Vorschläge (z.B. Hilfsmethoden, bessere Namen)
- Vorschläge für weitere Testfälle (z.B. Sonderfälle, Leerzeichen-Varianten)

(3) KI-Log führen ([ki-log.md](./ki-log.md))
- Jede KI-Nutzung dokumentieren:
    - Datum/Uhrzeit
    - verwendeter Prompt
    - kurz: Was wurde übernommen? (z.B. „Alternative Schleifenlösung“, „Idee für Tests mit Leerzeichen“)
    - Beispiel siehe [ki-log.md](./ki-log.md)

(4) Wichtig:
- Sie sind verantwortlich, die KI-Vorschläge kritisch zu prüfen und ggf. anzupassen.
- Das spätere Quiz zur Einheit wird ohne KI bearbeitet.

---

**Technische Hinweise**
- Projekt-Typ: Maven, Java (z.B. JDK 17), JUnit 5.
- Tests ausführen:
    - In IntelliJ: Rechtsklick auf PasswordStrengthEvaluatorTest → Run 'PasswordStrengthEvaluatorTest'
    - Über die Konsole: mvn test

**Rahmenbedingungen**
- Halten Sie sich an die vorgegebene Methodensignatur (public static String evaluateStrength(String password)).
- Dokumentieren Sie jede KI-Nutzung vollständig in ki-log.md.
- Arbeiten Sie weiterhin im Sinne von TDD: Tests geben den Takt vor, nicht die KI.

