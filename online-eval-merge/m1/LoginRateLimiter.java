package org.keycloak.onlineeval;

import java.util.ArrayDeque;
import java.util.Deque;

public class LoginRateLimiter {
    private final int maxAttempts;
    private final long windowMillis;
    private final Deque<Long> attempts = new ArrayDeque<>();

    public LoginRateLimiter(int maxAttempts, long windowMillis) {
        this.maxAttempts = maxAttempts;
        this.windowMillis = windowMillis;
    }

    public boolean allow(long now) {
        while (!attempts.isEmpty() && attempts.peekFirst() < now - windowMillis) {
            attempts.pollFirst();
        }
        if (attempts.size() >= maxAttempts) {
            return false;
        }
        attempts.addLast(now);
        return true;
    }

    public int remaining() {
        return maxAttempts - attempts.size() + 1;
    }
}
