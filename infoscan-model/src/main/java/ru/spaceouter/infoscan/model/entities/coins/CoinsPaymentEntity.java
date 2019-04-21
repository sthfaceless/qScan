package ru.spaceouter.infoscan.model.entities.coins;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spaceouter.infoscan.model.entities.user.UserEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author danil
 * @date 21.04.19
 */
@Entity
@Data
@Table(name = "coins_payments")
@NoArgsConstructor
public class CoinsPaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coins_payment_id", unique = true, nullable = false)
    private long coinsPaymentId;

    @Column(name = "quantity", nullable = false)
    private long quantity;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "service", nullable = false)
    private String service;

    @JoinColumn(name = "coins_id", nullable = false, foreignKey = @ForeignKey(name = "coins_payments_fk"))
    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CoinsEntity coins;

    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "user_payments_fk"))
    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserEntity user;

    public CoinsPaymentEntity(long quantity, Date date, String service) {
        this.quantity = quantity;
        this.date = date;
        this.service = service;
    }
}
