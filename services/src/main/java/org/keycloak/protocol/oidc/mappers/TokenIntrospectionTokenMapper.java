package org.keycloak.protocol.oidc.mappers;

import org.keycloak.models.ClientSessionContext;
import org.keycloak.models.KeycloakRequestSession;
import org.keycloak.models.ProtocolMapperModel;
import org.keycloak.models.UserSessionModel;
import org.keycloak.representations.AccessToken;

public interface TokenIntrospectionTokenMapper {
    AccessToken transformIntrospectionToken(AccessToken token, ProtocolMapperModel mappingModel, KeycloakRequestSession session,
                                       UserSessionModel userSession, ClientSessionContext clientSessionCtx);
}
