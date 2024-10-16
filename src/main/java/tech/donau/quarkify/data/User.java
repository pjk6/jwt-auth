package tech.donau.quarkify.data;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name="Users")
public class User extends PanacheEntity {
    public String login;
    public String password;
    public String roles;
    public String email;
}
