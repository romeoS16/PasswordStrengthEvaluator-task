# Aufgabe – PasswordStrengthEvaluator (Gruppe B – TDD, keine KI)

In dieser Aufgabe üben Sie **Test-Driven Development (TDD)** an einer evaluateStrength-Funktion.  
Sie schreiben zuerst Tests und entwickeln dann Schritt für Schritt die Implementierung.

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

Arbeiten Sie in kleinen TDD-Schritten:

(1) **Red** – Test schreiben
- Formulieren Sie zunächst in PasswordStrengthEvaluatorTest einen Testfall für einen einfachen Fall.
- Führen Sie die Tests aus – der neue Test sollte zunächst fehlschlagen.

(2) **Green** – minimaler Code
- Implementieren Sie evaluateStrength(...) so, dass der Test besteht.
- Schreiben Sie zunächst nur so viel Code wie nötig, um den Test grün zu bekommen.

(3) **Refactor** – aufräumen
- Verbessern Sie bei Bedarf Ihren Code (z.B. übersichtliche Schleife, Hilfsvariablen),
  ohne das beobachtbare Verhalten zu ändern. Alle Tests müssen grün bleiben.

(4) Weitere Tests hinzufügen
- Ergänzen Sie weitere Testfälle

---

**Technische Hinweise**
- Projekt-Typ: Maven, Java (z.B. JDK 17), JUnit 5.
- Tests ausführen:
    - In IntelliJ: Rechtsklick auf PasswordStrengthEvaluatorTest → Run 'PasswordStrengthEvaluatorTest'
    - Über die Konsole: mvn test

**Rahmenbedingungen**
- Verwenden Sie keine KI-Tools (z.B. ChatGPT, Copilot) zur Bearbeitung dieser Aufgabe.
- Halten Sie sich an die vorgegebene Methodensignatur (public static String evaluateStrength(String password)).
- Schreiben Sie konsequent Tests zuerst und lassen Sie sich von ihnen durch die Implementierung führen.

