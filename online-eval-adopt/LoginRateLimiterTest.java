package org.keycloak.onlineeval;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LoginRateLimiterTest {

    @Test
    void allowsExactlyMaxAttemptsPerWindow() {
        LoginRateLimiter limiter = new LoginRateLimiter(2, 1000);
        assertTrue(limiter.allow(0));
        assertTrue(limiter.allow(10));
        assertFalse(limiter.allow(20));
    }

    @Test
    void forgetsAttemptsOutsideTheWindow() {
        LoginRateLimiter limiter = new LoginRateLimiter(1, 1000);
        assertTrue(limiter.allow(0));
        assertTrue(limiter.allow(1500));
        assertEquals(0, limiter.remaining(1600));
        assertEquals(1, limiter.remaining(3000));
    }
}
