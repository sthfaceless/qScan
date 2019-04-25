package ru.spaceouter.infoscan.model.entities.orders;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spaceouter.infoscan.dto.view.orders.SocialNetworkType;

import javax.persistence.*;

/**
 * @author danil
 * @date 21.04.19
 */
@Entity
@Data
@Table(name = "order_social_networks")
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "getSocialNetworksByOrder",
            query = "select new ru.spaceouter.infoscan.dto.view.orders.SocialNetworkDTO(sn.socialNetworkId, sn.type, sn.link) from SocialNetwork sn " +
                    "left join sn.orderInformation i left join i.order o where i.order = :order and o.user = :user"),
        @NamedQuery(name = "getModelSocialNetwork",
            query = "select new ru.spaceouter.infoscan.dto.model.ModelSocialNetworkDTO(sn.socialNetworkId, o.orderId, sn.type) from SocialNetwork sn " +
                    "left join sn.orderInformation i left join i.order o where o.orderId = :order and o.user = :user")
})
public class SocialNetwork {

    public static final String GET_SOCIAL_NETWORKS_BY_ORDER = "getSocialNetworksByOrder";
    public static final String GET_MODEL_SOCIAL_NETWORK = "getModelSocialNetwork";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "social_network_id", nullable = false, unique = true)
    private long socialNetworkId;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SocialNetworkType type;

    @Column(name = "link", nullable = false)
    private String link;

    @JoinColumn(name = "order_information_id", nullable = false, foreignKey = @ForeignKey(name = "social_network_order_information_fk"))
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private OrderInformation orderInformation;

    public SocialNetwork(SocialNetworkType type, String link) {
        this.type = type;
        this.link = link;
    }
}
