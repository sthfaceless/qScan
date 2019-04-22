package ru.spaceouter.infoscan.model.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.spaceouter.infoscan.dto.coins.PaymentDTO;
import ru.spaceouter.infoscan.model.CoinsCustomDAO;
import ru.spaceouter.infoscan.model.entities.coins.CoinsPaymentEntity;
import ru.spaceouter.infoscan.model.entities.user.UserEntity;

import java.util.List;

/**
 * @author danil
 * @date 22.04.19
 */
@Repository
public class CoinsCustomDAOImpl extends AbstractHibernateDAO implements CoinsCustomDAO{

    public CoinsCustomDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<PaymentDTO> getPayments(long userId) {

        Session session = session();

        return session.createNamedQuery(CoinsPaymentEntity.GET_PAYMENTS_BY_USER, PaymentDTO.class)
                .setParameter("user", session.load(UserEntity.class, userId))
                .getResultList();
    }

}
