package ru.spaceouter.infoscan.model.entities.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author danil
 * @date 20.04.19
 */
@Entity
@Data
@Table(name = "users_credentials")
@NoArgsConstructor
@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(name = "getAuthByEmail",
                query = "select authId from AuthEntity where email = :email"),
        @org.hibernate.annotations.NamedQuery(name = "getAuthByUserId",
        query = "select authId frpm AuthEntity where user = :user")
})
public class AuthEntity {

    public static final String GET_AUTH_BY_EMAIL = "getAuthByEmail";
    public static final String GET_AUTH_BY_USER_ID = "getAuthByUserId";

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

    @Column(name = "expired_date", nullable = false)
    private Date expiredDate;

    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToOne(mappedBy = "auth", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false, orphanRemoval = true)
    private ActivationEntity activation;

    @OneToOne(mappedBy = "auth", orphanRemoval = true, optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RoleEntity role;

    @JoinColumn(name = "user_id", nullable = false, unique = true, foreignKey = @ForeignKey(name="auth_user_fk"))
    @OneToOne(optional = false, fetch = FetchType.LAZY, orphanRemoval = true)
    private UserEntity user;

    public AuthEntity(String username, String password, String token, boolean active, RoleEntity role) {
        this.username = username;
        this.password = password;
        this.token = token;
        this.active = active;
        this.role = role;
    }
}
