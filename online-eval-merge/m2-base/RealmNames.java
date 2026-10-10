package org.keycloak.onlineeval;

public final class RealmNames {
    private RealmNames() {
    }

    public static boolean sameRealm(String a, String b) {
        if (a == null || b == null) {
            return false;
        }
        return normalize(a).equals(normalize(b));
    }

    public static String normalize(String name) {
        return name.toLowerCase();
    }
}
