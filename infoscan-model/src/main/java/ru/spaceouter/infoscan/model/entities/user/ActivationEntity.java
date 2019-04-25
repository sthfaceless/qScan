package ru.spaceouter.infoscan.model.entities.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author danil
 * @date 22.04.19
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "activations")
@NamedQueries({
        @NamedQuery(name = "setConfirmPasswordToken",
                query = "update ActivationEntity set confirmRestore = :uuid where auth = :auth"),
        @NamedQuery(name = "setConfirmEmailToken",
                query = "update ActivationEntity set confirmEmail = :uuid, tempEmail = :email where auth = :auth"),
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "activateAccount",
                query = "update users_credentials uc left join activations a on uc.auth_id = a.auth_id " +
                        "set uc.active = true " +
                        "where a.activate_account = :str"),
        @NamedNativeQuery(name = "confirmEmail",
                query = "update users u " +
                        "left join users_credentials uc on uc.user_id = u.user_id " +
                        "left join activations a on uc.auth_id = a.auth_id " +
                        "set u.email = a.temp_email " +
                        "where a.confirm_email = :str"),
        @NamedNativeQuery(name = "confirmPassword",
                query = "update users_credentials uc left join activations a on uc.auth_id = a.auth_id " +
                        "set uc.password = :pass " +
                        "where a.confirm_restore = :str")
})
public class ActivationEntity {

    public static final String ACTIVATE_ACCOUNT = "activateAccount";
    public static final String CONFIRM_PASSWORD = "confirmPassword";
    public static final String CONFIRM_EMAIL = "confirmEmail";
    public static final String SET_CONFIRM_PASSWORD_TOKEN = "setConfirmPasswordToken";
    public static final String SET_CONFIRM_EMAIL_TOKEN = "setConfirmEmailToken";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activations_id", unique = true, nullable = false)
    private long activationId;

    @Column(name = "activate_account")
    private String activateAccount;

    @Column(name = "confirm_restore")
    private String confirmRestore;

    @Column(name = "confirm_email")
    private String confirmEmail;

    @Column(name = "temp_email")
    private String tempEmail;

    @JoinColumn(name = "auth_id", nullable = false, unique = true, foreignKey = @ForeignKey(name = "auth_activations_fk"))
    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AuthEntity auth;

    public ActivationEntity(AuthEntity auth) {
        this.auth = auth;
    }
}
