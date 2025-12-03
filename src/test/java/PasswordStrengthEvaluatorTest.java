import de.ba.experiment.PasswordStrengthEvaluator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PasswordStrengthEvaluatorTest {

    // In dieser Gruppe arbeiten Sie mit TDD und dürfen zusätzlich KI nutzen.
    // Wichtig: Schreiben Sie zuerst eigene Testfälle OHNE KI.
    // Bevor Sie eine KI um Hilfe bitten (siehe README und ki-log.md).

    @Test
    public void nullPassword_isWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength(null);
        assertEquals("WEAK", result);
    }

    // TODO: weitere Tests ergänzen

}
