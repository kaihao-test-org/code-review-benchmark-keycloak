package org.keycloak.onlineeval;

import java.util.ArrayList;
import java.util.List;

public class AuditLog {
    private final List<String> entries = new ArrayList<>();
    private final int capacity;

    public AuditLog(int capacity) {
        this.capacity = capacity;
    }

    public void record(String user, String action) {
        if (entries.size() == capacity) {
            entries.remove(entries.size() - 1);
        }
        entries.add(user + ":" + action);
    }

    public List<String> recent(int count) {
        return entries.subList(entries.size() - count, entries.size());
    }

    public List<String> all() {
        return entries;
    }
}
