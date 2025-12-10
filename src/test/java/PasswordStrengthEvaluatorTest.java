import de.ba.experiment.PasswordStrengthEvaluator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PasswordStrengthEvaluatorTest {

    // Vorgabe aus dem Aufgabenblatt

    @Test
    public void nullPassword_isWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength("ab1");
        assertEquals("WEAK", result);
    }

    // A: Ungültige Passwörter

    @Test
    public void emptyPassword_isWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength("");
        assertEquals("WEAK", result);
    }

    @Test
    public void passwordWithSpace_isWeak() {
        String result1 = PasswordStrengthEvaluator.evaluateStrength("Abc 123");
        String result2 = PasswordStrengthEvaluator.evaluateStrength(" pass");
        String result3 = PasswordStrengthEvaluator.evaluateStrength("pass ");

        assertEquals("WEAK", result1);
        assertEquals("WEAK", result2);
        assertEquals("WEAK", result3);
    }

    // B: Länge < 6 -> immer WEAK


    @Test
    public void veryShortPassword_isWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength("a");
        assertEquals("WEAK", result);
    }

    @Test
    public void shortButComplexPassword_isWeak() {
        // enthält Kleinbuchstaben, Großbuchstaben, Ziffer, Sonderzeichen,
        // ist aber zu kurz (< 6)
        String result = PasswordStrengthEvaluator.evaluateStrength("Ab1!");
        assertEquals("WEAK", result);
    }

    // C: 0–2 Punkte -> WEAK

    @Test
    public void lowercaseAndDigits_isWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength("abc123");
        // Kleinbuchstaben + Ziffern -> 2 Punkte -> WEAK
        assertEquals("WEAK", result);
    }

    @Test
    public void longButOnlyLowercase_isStillWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength("abcdefghij");
        // Kleinbuchstaben + Länge >= 10 -> 2 Punkte -> WEAK
        assertEquals("WEAK", result);
    }

    @Test
    public void upperAndLowerCase_isWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength("abcABC");
        // Kleinbuchstaben + Großbuchstabe -> 2 Punkte -> WEAK
        assertEquals("WEAK", result);
    }

    @Test
    public void upperCaseAndSpecialLetter_isWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength("ABCDE!&");
        // Großbuchstabe + Sonderzeichen -> 2 Punkte -> WEAK
        assertEquals("WEAK", result);
    }


    @Test
    public void longOnlyDigits_isWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength("1234567890");
        // Ziffern + Länge >= 10 -> 2 Punkte -> WEAK
        assertEquals("WEAK", result);
    }

    // D: Genau 3 Punkte -> MEDIUM

    @Test
    public void exampleFromSpec_Abc123_isMedium() {
        String result = PasswordStrengthEvaluator.evaluateStrength("Abc123");
        // Groß + klein + Ziffer -> 3 Punkte -> MEDIUM
        assertEquals("MEDIUM", result);
    }

    @Test
    public void upperLowerDigit_lengthSeven_isMedium() {
        String result = PasswordStrengthEvaluator.evaluateStrength("Abcdef1");
        // Groß + klein + Ziffer, Länge < 10 -> 3 Punkte -> MEDIUM
        assertEquals("MEDIUM", result);
    }

    // E: 4 oder 5 Punkte -> STRONG

    @Test
    public void allCharTypes_butLengthBelowTen_isStrong() {
        String result = PasswordStrengthEvaluator.evaluateStrength("Abcdef1!");
        // Groß + klein + Ziffer + Sonderzeichen, Länge < 10 -> 4 Punkte -> STRONG
        assertEquals("STRONG", result);
    }

    @Test
    public void noSpecialButLongEnough_isStrong() {
        String result = PasswordStrengthEvaluator.evaluateStrength("Abcdef1234");
        // Groß + klein + Ziffer + Länge >= 10 -> 4 Punkte -> STRONG
        assertEquals("STRONG", result);
    }

    @Test
    public void allCriteriaMet_isStrong() {
        String result = PasswordStrengthEvaluator.evaluateStrength("Abcdef12!x");
        // Groß + klein + Ziffer + Sonderzeichen + Länge>=10 -> 5 Punkte -> STRONG
        assertEquals("STRONG", result);
    }

    @Test
    public void longComplexPasswordFromSpec_isStrong() {
        String result = PasswordStrengthEvaluator.evaluateStrength("aaaAAAbbb!223j");
        // Beispiel aus Aufgabenstellung -> STRONG
        assertEquals("STRONG", result);
    }

    // F: Sonderfälle / „komische“ Kombinationen

    @Test
    public void onlySpecialChars_isWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength("!!!!??");
        // nur Sonderzeichen -> 1 Punkt -> WEAK
        assertEquals("WEAK", result);
    }
}
