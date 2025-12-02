import de.ba.experiment.PasswordStrengthEvaluator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PasswordStrengthEvaluatorTest {

    // --- Ungültige / triviale Fälle ---

    @Test
    public void nullPassword_isWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength(null);
        assertEquals("WEAK", result);
    }

    @Test
    public void emptyPassword_isWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength("");
        assertEquals("WEAK", result);
    }

    @Test
    public void passwordWithSpace_isWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength("Abc 123!");
        assertEquals("WEAK", result);
    }

    @Test
    public void shortPassword_belowLengthSix_isWeak_evenIfFancy() {
        // Länge 5, enthält aber Groß-/Kleinbuchstaben, Ziffer und Sonderzeichen
        String result = PasswordStrengthEvaluator.evaluateStrength("Ab1!");
        assertEquals("WEAK", result);
    }

    // --- Einfache gültige Passwörter (Länge >= 6) ---

    @Test
    public void onlyLowercaseLetters_minLength_isWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength("abcdef");
        // Kriterien: nur Kleinbuchstaben -> 1 Punkt
        assertEquals("WEAK", result);
    }

    @Test
    public void lowercaseAndDigits_isWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength("abc123");
        // Kriterien: Kleinbuchstaben + Ziffern -> 2 Punkte
        assertEquals("WEAK", result);
    }

    // --- MEDIUM-Fälle (genau 3 Punkte) ---

    @Test
    public void upperLowerAndDigit_lengthSix_isMedium() {
        String result = PasswordStrengthEvaluator.evaluateStrength("Abc123");
        // Kriterien: Groß + klein + Ziffer (3 Punkte), Länge < 10 -> 3 Punkte -> MEDIUM
        assertEquals("MEDIUM", result);
    }

    @Test
    public void mediumPassword_example_isMedium() {
        String result = PasswordStrengthEvaluator.evaluateStrength("Abcdef12");
        // Groß + klein + Ziffer, Länge >= 6 aber < 10, kein Sonderzeichen -> 3 Punkte -> MEDIUM
        assertEquals("MEDIUM", result);
    }

    // --- STRONG-Fälle (>= 4 Punkte) ---

    @Test
    public void strongPassword_withAllCharTypes_isStrong_evenIfLengthBelowTen() {
        String result = PasswordStrengthEvaluator.evaluateStrength("Abcdef1!");
        // Groß + klein + Ziffer + Sonderzeichen (4 Punkte), Länge < 10 -> 4 Punkte -> STRONG
        assertEquals("STRONG", result);
    }

    @Test
    public void strongPassword_withAllCharTypes_andLengthAtLeastTen_isStrong() {
        String result = PasswordStrengthEvaluator.evaluateStrength("Abcdef12!x");
        // Groß + klein + Ziffer + Sonderzeichen + Länge>=10 -> 5 Punkte -> STRONG
        assertEquals("STRONG", result);
    }

    @Test
    public void strongPassword_withoutSpecialButLongEnough_isStrong() {
        String result = PasswordStrengthEvaluator.evaluateStrength("Abcdef1234");
        // Groß + klein + Ziffer + Länge>=10 -> 4 Punkte -> STRONG
        assertEquals("STRONG", result);
    }

    // --- Grenzfälle rund um die Punktgrenzen ---

    @Test
    public void passwordWithExactlyTwoCriteria_isWeak() {
        // Kleinbuchstaben + Länge>=10, aber keine Ziffer, kein Großbuchstabe, kein Sonderzeichen
        String result = PasswordStrengthEvaluator.evaluateStrength("abcdefghij");
        // hasLower + length>=10 -> 2 Punkte -> WEAK
        assertEquals("WEAK", result);
    }

    @Test
    public void passwordWithExactlyThreeCriteria_isMedium() {
        // Groß + klein + Ziffer, Länge < 10, kein Sonderzeichen
        String result = PasswordStrengthEvaluator.evaluateStrength("Abc1234");
        // 3 Punkte -> MEDIUM
        assertEquals("MEDIUM", result);
    }

    @Test
    public void passwordWithExactlyFourCriteria_isStrong() {
        // Groß + klein + Ziffer + Sonderzeichen, Länge < 10
        String result = PasswordStrengthEvaluator.evaluateStrength("Abc12!x");
        // 4 Punkte -> STRONG
        assertEquals("STRONG", result);
    }
}
