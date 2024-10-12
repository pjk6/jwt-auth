package tech.donau.quarkify.data;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name="Users")
//@UserDefinition()
public class User extends PanacheEntity {
    //@Username
    public String login;
    //@Password
    public String password;
    public String email;

    /**
     * Adds a new user to the database
     * @param login the username
     * @param password the unencrypted password (it is encrypted with bcrypt)
     * @param role the comma-separated roles
     */
//    public static void add(String username, String password, String role) {
//        User user = new User();
//        user.username = username;
//        user.password = BcryptUtil.bcryptHash(password);
//        user.role = role;
//        user.persist();
//    }
}
