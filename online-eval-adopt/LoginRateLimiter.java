package org.keycloak.onlineeval;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Allows at most {@code maxAttempts} login attempts per sliding window of {@code windowMillis}.
 */
public class LoginRateLimiter {
    private final int maxAttempts;
    private final long windowMillis;
    private final Deque<Long> attempts = new ArrayDeque<>();

    public LoginRateLimiter(int maxAttempts, long windowMillis) {
        this.maxAttempts = maxAttempts;
        this.windowMillis = windowMillis;
    }

    public synchronized boolean allow(long now) {
        evictExpired(now);
        if (attempts.size() >= maxAttempts) {
            return false;
        }
        attempts.addLast(now);
        return true;
    }

    public synchronized int remaining(long now) {
        evictExpired(now);
        return maxAttempts - attempts.size();
    }

    private void evictExpired(long now) {
        while (!attempts.isEmpty() && attempts.peekFirst() < now - windowMillis) {
            attempts.pollFirst();
        }
    }
}
