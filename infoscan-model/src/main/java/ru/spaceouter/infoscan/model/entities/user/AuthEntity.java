package ru.spaceouter.infoscan.model.entities.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author danil
 * @date 20.04.19
 */
@Entity
@Data
@Table(name = "users_credentials")
@NoArgsConstructor
public class AuthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_id", nullable = false, unique = true)
    private long authId;

    @Column(name = "username", unique = true, nullable = false, length = 64)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "token", unique = true, nullable = false, length = 128)
    private String token;

    @OneToOne(mappedBy = "auth", orphanRemoval = true, optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RoleEntity role;

    @JoinColumn(name = "user_id", nullable = false, unique = true, foreignKey = @ForeignKey(name="auth_user_fk"))
    @OneToOne(optional = false, fetch = FetchType.LAZY, orphanRemoval = true)
    private UserEntity user;

    public AuthEntity(String username, String password, String token, RoleEntity role) {
        this.username = username;
        this.password = password;
        this.token = token;
        this.role = role;
    }
}
