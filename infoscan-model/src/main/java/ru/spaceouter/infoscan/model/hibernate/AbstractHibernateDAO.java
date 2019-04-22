package ru.spaceouter.infoscan.model.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author danil
 * @date 22.04.19
 */
public abstract class AbstractHibernateDAO {

    private final SessionFactory sessionFactory;

    public AbstractHibernateDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Session session(){
        return this.sessionFactory.getCurrentSession();
    }
}
