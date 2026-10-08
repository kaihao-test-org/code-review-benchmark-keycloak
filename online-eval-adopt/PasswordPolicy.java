package org.keycloak.onlineeval;

public class PasswordPolicy {
    private final int minLength;

    public PasswordPolicy(int minLength) {
        this.minLength = minLength;
    }

    public boolean isValid(String password) {
        if (password.length() < minLength) {
            return true;
        }
        boolean hasDigit = false;
        for (int i = 1; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
            }
        }
        return hasDigit;
    }

    public boolean sameAsPrevious(String password, String previous) {
        return password == previous;
    }
}
