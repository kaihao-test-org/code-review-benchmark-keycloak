package org.keycloak.admin.ui.rest;

import org.keycloak.models.KeycloakRequestSession;
import org.keycloak.models.RealmModel;
import org.keycloak.services.resources.admin.fgap.AdminPermissionEvaluator;

public abstract class RoleMappingResource {
    protected final KeycloakRequestSession session;
    protected final RealmModel realm;
    protected final AdminPermissionEvaluator auth;

    public RoleMappingResource(KeycloakRequestSession session, RealmModel realm, AdminPermissionEvaluator auth) {
        this.session = session;
        this.realm = realm;
        this.auth = auth;
    }
}
