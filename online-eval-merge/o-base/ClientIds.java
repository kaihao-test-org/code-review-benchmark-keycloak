package org.keycloak.onlineeval;

public final class ClientIds {
    private ClientIds() {
    }

    public static boolean isValid(String id) {
        return id.length() > 0 && id.length() < 255;
    }

    public static String display(String id) {
        return id.substring(0, 8);
    }
}
