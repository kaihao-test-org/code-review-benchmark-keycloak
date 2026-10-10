package org.keycloak.onlineeval;

public final class RealmNames {
    private RealmNames() {
    }

    public static boolean sameRealm(String a, String b) {
        return a.equals(b);
    }

    public static String normalize(String name) {
        return name.toLowerCase();
    }
}
