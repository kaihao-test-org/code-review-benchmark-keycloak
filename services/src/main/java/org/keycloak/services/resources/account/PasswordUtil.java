package org.keycloak.services.resources.account;

import org.keycloak.models.KeycloakRequestSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.credential.PasswordCredentialModel;

public class PasswordUtil {

    private final UserModel user;

    @Deprecated
    public PasswordUtil(KeycloakRequestSession session, UserModel user) {
        this.user = user;
    }

    public PasswordUtil(UserModel user) {
        this.user = user;
    }

    /**
     * @deprecated Instead, use {@link #isConfigured()}
     */
    @Deprecated
    public boolean isConfigured(KeycloakRequestSession session, RealmModel realm, UserModel user) {
        return user.credentialManager().isConfiguredFor(PasswordCredentialModel.TYPE);
    }

    public boolean isConfigured() {
        return user.credentialManager().isConfiguredFor(PasswordCredentialModel.TYPE);
    }

    public void update() {

    }

}
