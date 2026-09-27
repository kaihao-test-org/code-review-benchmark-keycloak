package org.keycloak.crypto;

import org.keycloak.common.VerificationException;
import org.keycloak.jose.jws.JWSInput;
import org.keycloak.models.ClientModel;
import org.keycloak.models.KeycloakRequestSession;

public class ECDSAClientSignatureVerifierProvider implements ClientSignatureVerifierProvider {
    private final KeycloakRequestSession session;
    private final String algorithm;

    public ECDSAClientSignatureVerifierProvider(KeycloakRequestSession session, String algorithm) {
        this.session = session;
        this.algorithm = algorithm;
    }

    @Override
    public SignatureVerifierContext verifier(ClientModel client, JWSInput input) throws VerificationException {
        return new ClientECDSASignatureVerifierContext(session, client, input);
    }

    @Override
    public String getAlgorithm() {
        return algorithm;
    }

    @Override
    public boolean isAsymmetricAlgorithm() {
        return true;
    }
}
