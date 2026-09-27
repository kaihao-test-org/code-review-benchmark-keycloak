package org.keycloak.authentication;

import org.keycloak.credential.CredentialModel;
import org.keycloak.credential.CredentialProvider;
import org.keycloak.models.KeycloakRequestSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

import java.util.List;
import java.util.stream.Collectors;

public interface CredentialValidator<T extends CredentialProvider> {
    T getCredentialProvider(KeycloakRequestSession session);
    default List<CredentialModel> getCredentials(KeycloakRequestSession session, RealmModel realm, UserModel user) {
        return user.credentialManager().getStoredCredentialsByTypeStream(getCredentialProvider(session).getType())
                .collect(Collectors.toList());
    }
    default String getType(KeycloakRequestSession session) {
        return getCredentialProvider(session).getType();
    }
}
