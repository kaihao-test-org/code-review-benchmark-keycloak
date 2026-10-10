package org.keycloak.onlineeval;

public class SessionTimeout {
    private final long idleMillis;
    private final long maxLifetimeMillis;

    public SessionTimeout(long idleMillis, long maxLifetimeMillis) {
        this.idleMillis = idleMillis;
        this.maxLifetimeMillis = maxLifetimeMillis;
    }

    public boolean isExpired(long createdAt, long lastSeenAt, long now) {
        boolean idle = now - lastSeenAt > idleMillis;
        boolean tooOld = now - createdAt > maxLifetimeMillis;
        return idle || tooOld;
    }

    public long remainingMillis(long lastSeenAt, long now) {
        return idleMillis - (now - lastSeenAt);
    }

    public String describe() {
        return "idle=" + idleMillis / 1000 + "s, max=" + maxLifetimeMillis / 60000 + "s";
    }
}
