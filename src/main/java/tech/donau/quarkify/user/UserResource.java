package tech.donau.quarkify.user;

import tech.donau.quarkify.data.User;
import tech.donau.quarkify.security.Roles;
import tech.donau.quarkify.security.TokenService;

import io.quarkus.elytron.security.common.BcryptUtil;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.jboss.logging.Logger;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private static final Logger LOG = Logger.getLogger(UserResource.class);

    @Inject
    TokenService service;

    @POST
    @Path("/register")
    @Transactional
    public User register(User user) {
        // Encrypt password using Bcrypt
        user.password = BcryptUtil.bcryptHash(user.password);

        // Add default USER role to the registered user
        user.roles = Roles.USER;

        // Check if the user already exists
        if(User.find("login", user.login).firstResult() != null){
            throw new WebApplicationException(Response.status(409)
                    .entity("User already exists!")
                    .build());
        }

        // Save the user into the database
        user.persist();

        return user;
    }

    @GET
    @Path("/login")
    public String login(@QueryParam("login") String login, @QueryParam("password") String password) {
        User existingUser = User.find("login", login)
                                .firstResult();
        if(existingUser == null || !BcryptUtil.matches(password, existingUser.password)) {
                throw new WebApplicationException(Response.status(404)
                        .entity("No user found or wrong password")
                        .build());
        }

        return service.generateUserToken(existingUser.email, password);
    }
}
