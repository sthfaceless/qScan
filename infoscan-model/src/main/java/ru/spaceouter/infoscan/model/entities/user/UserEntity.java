package ru.spaceouter.infoscan.model.entities.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author danil
 * @date 21.04.19
 */
@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private long userId;

    @Column(name = "username", unique = true, nullable = false, length = 64)
    private String username;

    @Column(name = "email", unique = true, nullable = false, length = 64)
    private String email;

    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,optional = false, fetch = FetchType.LAZY, orphanRemoval = true)
    private AuthEntity auth;

    public UserEntity(String username, String email, Date registrationDate) {
        this.username = username;
        this.email = email;
        this.registrationDate = registrationDate;
    }
}
