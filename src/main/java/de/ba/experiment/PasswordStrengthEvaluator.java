package de.ba.experiment;

public class PasswordStrengthEvaluator {
    /**
     * Bewertet die Stärke eines Passworts.
     *
     * (Siehe ausführliche Beschreibung im Aufgabenblatt)
     */
    public static String evaluateStrength(String password) {

        if(password == null){
            return "WEAK";
        }
        if(password.length() < 6){
            return "WEAK";
        }
        if(password.contains(" ")){
            return "WEAK";
        }

        int counter = 0;
        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialLetter = false;

        for(int i = 0; i < password.length(); i++){
            if(Character.isDigit(password.charAt(i))){
                hasDigit = true;
            }
            else if(Character.isUpperCase(password.charAt(i))){
                hasUpperCase = true;
            }
            else if(Character.isLowerCase(password.charAt(i))){
                hasLowerCase = true;
            }
            else if(!Character.isLetterOrDigit(password.charAt(i))){
                hasSpecialLetter = true;
            }
        }

        if(password.length() >= 10){
            counter++;}
        if(hasDigit){
            counter++; }
        if (hasUpperCase){
            counter++; }
        if(hasLowerCase){
            counter++;}
        if(hasSpecialLetter){
            counter++;}

        if(counter <= 2){
            return "WEAK";
        } else if (counter == 3){
            return "MEDIUM";
        } else {
            return "STRONG";
        }
    }
}
