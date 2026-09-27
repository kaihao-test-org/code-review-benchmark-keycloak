package org.keycloak.protocol.docker.mapper;

import org.keycloak.models.AuthenticatedClientSessionModel;
import org.keycloak.models.KeycloakRequestSession;
import org.keycloak.models.ProtocolMapperModel;
import org.keycloak.models.UserSessionModel;
import org.keycloak.representations.docker.DockerResponseToken;

public interface DockerAuthV2AttributeMapper {

    boolean appliesTo(DockerResponseToken responseToken);

    DockerResponseToken transformDockerResponseToken(DockerResponseToken responseToken, ProtocolMapperModel mappingModel,
                                                     KeycloakRequestSession session, UserSessionModel userSession, AuthenticatedClientSessionModel clientSession);
}
