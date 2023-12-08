package com.example.msusers.repository;


import com.example.msusers.domain.User;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Repository;


import javax.ws.rs.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;


@Repository
@RequiredArgsConstructor
public class KeycloakUserRepository implements IUserRepository{

    private final Keycloak keycloak;

    @Value("${ms-users.keycloak.realm}")
    private String realm;

    @Override
    public List<User> getAllUsers() {
        List<UserRepresentation> userRepresentation = keycloak.realm(realm)
                .users().list();
        return userRepresentation.stream().map(this::fromRepresentation).collect(Collectors.toList());
    }

    @Override
    public User findUserById(String id) throws NotFoundException {
        try {
            UserResource userResource = keycloak
                    .realm(realm)
                    .users().get(id);

            UserRepresentation userRepresentation = userResource.toRepresentation();
            return fromRepresentation(userRepresentation);
        } catch (NotFoundException e) {
            System.out.println(e);
            return null;
        }
    }

    private User fromRepresentation(UserRepresentation userRepresentation) {
        return new User(userRepresentation.getId(), userRepresentation.getUsername(), userRepresentation.getEmail(), userRepresentation.getFirstName(), userRepresentation.getLastName());
    }


}
