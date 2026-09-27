package org.keycloak.protocol.saml.mappers;

import org.keycloak.models.AuthenticatedClientSessionModel;
import org.keycloak.models.KeycloakRequestSession;
import org.keycloak.models.ProtocolMapperModel;
import org.keycloak.models.UserSessionModel;

public interface SAMLNameIdMapper {

    String mapperNameId(String nameIdFormat, ProtocolMapperModel mappingModel, KeycloakRequestSession session,
                                        UserSessionModel userSession, AuthenticatedClientSessionModel clientSession);

}