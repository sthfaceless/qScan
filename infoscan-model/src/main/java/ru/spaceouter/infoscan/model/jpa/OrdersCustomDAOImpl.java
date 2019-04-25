package ru.spaceouter.infoscan.model.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.spaceouter.infoscan.dto.model.ModelSocialNetworkDTO;
import ru.spaceouter.infoscan.dto.model.OrderModelDTO;
import ru.spaceouter.infoscan.dto.view.orders.*;
import ru.spaceouter.infoscan.exceptions.NotExistException;
import ru.spaceouter.infoscan.model.OrdersCustomDAO;
import ru.spaceouter.infoscan.model.entities.orders.OrderEntity;
import ru.spaceouter.infoscan.model.entities.orders.OrderInformation;
import ru.spaceouter.infoscan.model.entities.orders.SocialNetwork;
import ru.spaceouter.infoscan.model.entities.user.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

/**
 * @author danil
 * @date 23.04.19
 */
@Repository
@Transactional
public class OrdersCustomDAOImpl implements OrdersCustomDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ViewOrderDTO> getOrdersByUser(long userId, int start, int max) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ViewOrderDTO> query = cb.createQuery(ViewOrderDTO.class);
        Root<OrderEntity> order = query.from(OrderEntity.class);

        Join<OrderEntity, OrderInformation> info = order.join("orderInformation", JoinType.LEFT);

        query.select(cb.construct(ViewOrderDTO.class, order.get("orderId"),
                info.get("firstName"), info.get("lastName"), info.get("patronymic"), info.get("pseudoName"),
                order.get("createDate"), order.get("status")));

        query.orderBy(cb.desc(order.get("createDate")));

        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    @Override
    public FullOrderDTO getFullOrder(long orderId, long userId) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<FullOrderDTO> query = cb.createQuery(FullOrderDTO.class);
        Root<OrderEntity> order = query.from(OrderEntity.class);

        Join<OrderEntity, OrderInformation> info = order.join("orderInformation", JoinType.LEFT);

        query.select(cb.construct(FullOrderDTO.class, order.get("orderId"),
                info.get("firstName"), info.get("lastName"), info.get("patronymic"),
                info.get("ip"), info.get("phone"), info.get("picture"),
                info.get("pseudoName"), info.get("email"), info.get("alternate")));

        query.where(cb.and(cb.equal(order.get("orderId"), orderId),
                cb.equal(order.get("user"), em.getReference(UserEntity.class, userId))));

        FullOrderDTO fullOrderDTO = em.createQuery(query).getResultList().stream().findFirst().orElse(null);
        if(fullOrderDTO != null) fullOrderDTO.setSocialNetworks(getSocialNetwork(orderId, userId));

        return fullOrderDTO;
    }

    @Override
    public List<SocialNetworkDTO> getSocialNetwork(long orderId, long userId) {

        return em.createNamedQuery(SocialNetwork.GET_SOCIAL_NETWORKS_BY_ORDER, SocialNetworkDTO.class)
                .setParameter("order", em.getReference(OrderEntity.class, orderId))
                .setParameter("user", em.getReference(UserEntity.class, userId))
                .getResultList();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected OrderEntity saveOrderWithID(long userId, CreateOrderDTO createOrderDTO){

        OrderEntity orderEntity = new OrderEntity(new Date(),
                OrderStatus.ACCEPTED,
                "Anonymous");
        orderEntity.setUser(em.getReference(UserEntity.class, userId));

        OrderInformation orderInformation = new OrderInformation(
                createOrderDTO.getFirstName(),
                createOrderDTO.getLastName(),
                createOrderDTO.getPatronymic(),
                createOrderDTO.getIp(),
                createOrderDTO.getPhone(),
                createOrderDTO.getPicture(),
                createOrderDTO.getPseudoName(),
                createOrderDTO.getEmail(),
                createOrderDTO.getAlternate()
        );
        orderInformation.setOrder(orderEntity);
        orderEntity.setOrderInformation(orderInformation);

        em.persist(orderEntity);

        return orderEntity;
    }

    @Override
    public long saveOrder(long userId, CreateOrderDTO createOrderDTO) {

        return saveOrderWithID(userId, createOrderDTO).getOrderId();
    }

    @Override
    public boolean updateOrder(long orderId, String fieldName, String value, long userId) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<OrderInformation> update = cb.createCriteriaUpdate(OrderInformation.class);
        Root<OrderInformation> root = update.from(OrderInformation.class);

        long orderInformationId = getOrderInformationIdByOrderAndUser(orderId, userId);
        if(orderInformationId == 0)
            return false;

        update.set(fieldName, value);
        update.where(cb.equal(root.get("orderInformationId"), orderInformationId));

        return em.createQuery(update).executeUpdate() != 0;
    }

    private long getOrderInformationIdByOrderAndUser(long orderId, long userId){

        return em.createNamedQuery(OrderEntity.GET_ORDER_INFORMATION_BY_ORDER_AND_USER, Long.class)
                .setParameter("order", orderId)
                .setParameter("user", em.getReference(UserEntity.class, userId))
                .getResultList().stream().findFirst().orElse((long) 0);
    }

    @Override
    public long updateOrderSocialNetworks(SocialNetworkDTO socialNetworkDTO, long userId) throws NotExistException {

        long orderInformationId = getOrderInformationIdByOrder(socialNetworkDTO.getOrderId());
        if(orderInformationId == 0)
            throw new NotExistException();

        List<ModelSocialNetworkDTO> socialNetworks = getModelSocialNetwork(socialNetworkDTO.getOrderId(), userId);

        ModelSocialNetworkDTO existSocialNetwork = null;
        for(ModelSocialNetworkDTO socialNetwork : socialNetworks){
            if(socialNetwork.getType() == socialNetworkDTO.getType()) {
                existSocialNetwork = socialNetwork;
                break;
            }
        }

        SocialNetwork socialNetwork = new SocialNetwork(socialNetworkDTO.getType(), socialNetworkDTO.getLink());
        socialNetwork.setOrderInformation(em.getReference(OrderInformation.class, orderInformationId));
        if(existSocialNetwork != null) {
            socialNetwork.setSocialNetworkId(existSocialNetwork.getId());
            em.merge(socialNetwork);
        }else
            em.persist(socialNetwork);

        return socialNetworkDTO.getOrderId();
    }

    @Override
    public long getOrderInformationIdByOrder(long orderId) {

        return em.createNamedQuery(OrderEntity.GET_ORDER_INFORMATION_BY_ORDER_ID, Long.class)
                .setParameter("order", em.getReference(OrderEntity.class, orderId))
                .getResultList().stream().findFirst().orElse((long) 0);
    }

    public List<ModelSocialNetworkDTO> getModelSocialNetwork(long orderId, long userId){

        return em.createNamedQuery(SocialNetwork.GET_MODEL_SOCIAL_NETWORK, ModelSocialNetworkDTO.class)
                .setParameter("order", orderId)
                .setParameter("user", em.getReference(UserEntity.class, userId))
                .getResultList();
    }

}
