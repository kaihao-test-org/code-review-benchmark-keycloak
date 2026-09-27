package org.keycloak.services.ui.extend;

import org.keycloak.component.ComponentFactory;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakRequestSession;
import org.keycloak.provider.ProviderFactory;

public interface UiPageProviderFactory<T> extends ComponentFactory<T, UiPageProvider> {
    default T create(KeycloakRequestSession session, ComponentModel model) {
        return null;
    }
}
