package ru.spaceouter.infoscan.model.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.spaceouter.infoscan.dto.view.coins.PaymentDTO;
import ru.spaceouter.infoscan.model.CoinsCustomDAO;
import ru.spaceouter.infoscan.model.entities.coins.CoinsPaymentEntity;
import ru.spaceouter.infoscan.model.entities.user.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author danil
 * @date 22.04.19
 */
@Repository
@Transactional
public class CoinsCustomDAOImpl implements CoinsCustomDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PaymentDTO> getPayments(long userId) {

        return em.createNamedQuery(CoinsPaymentEntity.GET_PAYMENTS_BY_USER, PaymentDTO.class)
                .setParameter("user", em.getReference(UserEntity.class, userId))
                .getResultList();
    }

}
