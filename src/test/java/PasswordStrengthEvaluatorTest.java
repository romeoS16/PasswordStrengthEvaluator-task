import de.ba.experiment.PasswordStrengthEvaluator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PasswordStrengthEvaluatorTest {

    @Test
    public void nullPassword_isWeak() {
        String result = PasswordStrengthEvaluator.evaluateStrength(null);
        assertEquals("WEAK", result);
    }

    // TODO: weitere Tests ergänzen

}
