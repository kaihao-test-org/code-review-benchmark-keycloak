/*
 * Copyright 2022 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.keycloak.storage;

import org.keycloak.models.KeycloakRequestSession;
import org.keycloak.models.RealmModel;
import org.keycloak.provider.ProviderEvent;

/**
 * Event to trigger that will add defaults for a realm after it has been imported.
 *
 * @author Alexander Schwartz
 */
public class SetDefaultsForNewRealm implements ProviderEvent {
    private final KeycloakRequestSession session;
    private final RealmModel realmModel;

    public SetDefaultsForNewRealm(KeycloakRequestSession session, RealmModel realmModel) {
        this.session = session;
        this.realmModel = realmModel;
    }

    public static void fire(KeycloakRequestSession session, RealmModel realm) {
        SetDefaultsForNewRealm event = new SetDefaultsForNewRealm(session, realm);
        session.getKeycloakSessionFactory().publish(event);
    }

    public KeycloakRequestSession getSession() {
        return session;
    }

    public RealmModel getRealmModel() {
        return realmModel;
    }
}

