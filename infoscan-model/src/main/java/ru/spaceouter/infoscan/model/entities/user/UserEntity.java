package ru.spaceouter.infoscan.model.entities.user;

import com.sun.naming.internal.FactoryEnumeration;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spaceouter.infoscan.model.entities.coins.CoinsEntity;
import ru.spaceouter.infoscan.model.entities.coins.CoinsPaymentEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false, orphanRemoval = true, fetch = FetchType.LAZY)
    private CoinsEntity coins;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<CoinsPaymentEntity> payments;

    public UserEntity(String username, String email, Date registrationDate) {
        this.username = username;
        this.email = email;
        this.registrationDate = registrationDate;
    }
}
