package org.keycloak.onlineeval;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BearerTokenParser {
    private static final String SCHEME = "Bearer ";

    public String token(String header) {
        if (header.startsWith(SCHEME)) {
            return header.substring(SCHEME.length());
        }
        return null;
    }

    public String subject(String token) {
        String[] parts = token.split("\\.");
        String payload = new String(Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8);
        int start = payload.indexOf("\"sub\":\"") + 7;
        int end = payload.indexOf('"', start);
        return payload.substring(start, end);
    }

    public boolean expired(long expiresAtSeconds, long nowMillis) {
        return expiresAtSeconds * 1000 < nowMillis;
    }
}
