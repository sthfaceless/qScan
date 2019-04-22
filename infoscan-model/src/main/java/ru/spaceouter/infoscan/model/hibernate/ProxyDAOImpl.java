package ru.spaceouter.infoscan.model.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.spaceouter.infoscan.model.entities.user.UserEntity;

/**
 * @author danil
 * @date 22.04.19
 */
@Repository
public class ProxyDAOImpl extends AbstractHibernateDAO implements ProxyDAO {

    public ProxyDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public UserEntity getUserProxy(long userId) {
        return session().load(UserEntity.class, userId);
    }
}
