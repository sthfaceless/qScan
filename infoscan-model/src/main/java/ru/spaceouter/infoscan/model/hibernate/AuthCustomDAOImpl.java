package ru.spaceouter.infoscan.model.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.spaceouter.infoscan.model.AuthCustomDAO;

/**
 * @author danil
 * @date 22.04.19
 */
@Repository
public class AuthCustomDAOImpl extends AbstractHibernateDAO implements AuthCustomDAO {

    public AuthCustomDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
