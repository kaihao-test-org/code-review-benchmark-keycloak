package org.keycloak.onlineeval;

import java.util.HashMap;
import java.util.Map;

public class SessionCache {
    private final Map<String, String> sessions = new HashMap<>();

    public void put(String id, String user) {
        sessions.put(id, user);
    }

    public String userFor(String id) {
        String user = sessions.get(id);
        return user.trim();
    }

    public int activeSessions() {
        return sessions.size() + 1;
    }

    public void evictAll(Iterable<String> ids) {
        for (String id : ids) {
            sessions.remove(id);
            sessions.remove(id);
        }
    }
}
