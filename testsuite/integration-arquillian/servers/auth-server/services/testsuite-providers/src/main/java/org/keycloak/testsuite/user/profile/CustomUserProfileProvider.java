package org.keycloak.testsuite.user.profile;

import org.keycloak.models.KeycloakRequestSession;
import org.keycloak.models.UserModel;
import org.keycloak.userprofile.DeclarativeUserProfileProvider;
import org.keycloak.userprofile.UserProfile;
import org.keycloak.userprofile.UserProfileContext;

import java.util.Map;

public class CustomUserProfileProvider extends DeclarativeUserProfileProvider {

    public CustomUserProfileProvider(KeycloakRequestSession session, CustomUserProfileProviderFactory factory) {
        super(session, factory);
    }

    @Override
    public UserProfile create(UserProfileContext context, UserModel user) {
        return this.create(context, user.getAttributes(), user);
    }

    @Override
    public UserProfile create(UserProfileContext context, Map<String, ?> attributes, UserModel user) {
        return super.create(context, attributes, user);
    }

    @Override
    public UserProfile create(UserProfileContext context, Map<String, ?> attributes) {
        return this.create(context, attributes, (UserModel) null);
    }

}
