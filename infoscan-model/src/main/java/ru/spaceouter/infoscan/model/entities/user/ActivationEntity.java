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
@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(name = "activateAccount",
                query = "update AuthEntity set active = true where authId in " +
                        "(select ae.authId from ActivationEntity a left join a.auth ae where a.activateAccount=:str)"),
        @org.hibernate.annotations.NamedQuery(name = "confirmPassword",
                query = "update AuthEntity set password = :pass where authId in " +
                        "(select ae.authId from ActivationEntity a left join a.auth ae where a.confirmRestore=:str)"),
        @org.hibernate.annotations.NamedQuery(name = "confirmEmail",
                query = "update AuthEntity set active = true where authId in " +
                        "(select ae.authId from ActivationEntity a left join a.auth ae where a.confirmEmail=:str)"),
        @org.hibernate.annotations.NamedQuery(name = "setConfirmPasswordToken",
        query = "update ActivationEntity set confirmRestore = :uuid where auth = :auth"),
        @org.hibernate.annotations.NamedQuery(name = "setConfirmEmailToken",
        query = "update ActivationEntity set confirmEmail = :uuid, tempEmail = :email where auth = :auth")
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

    @Column(name = "temp_password")
    private String tempPassword;

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
