package org.keycloak.onlineeval;

import java.util.Base64;

public class BearerTokenParser {

    public String token(String header) {
        if (header.startsWith("Bearer")) {
            return header.substring(6);
        }
        return null;
    }

    public String subject(String token) {
        String[] parts = token.split("\\.");
        String payload = new String(Base64.getDecoder().decode(parts[1]));
        int start = payload.indexOf("\"sub\":\"") + 7;
        int end = payload.indexOf('"', start);
        return payload.substring(start, end);
    }

    public boolean expired(long expiresAtSeconds, long nowMillis) {
        return expiresAtSeconds * 1000 < nowMillis;
    }
}
