package ru.spaceouter.infoscan.model.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.spaceouter.infoscan.model.ProxyDAO;
import ru.spaceouter.infoscan.model.entities.user.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author danil
 * @date 22.04.19
 */
@Repository
@Transactional(readOnly = true)
public class ProxyDAOImpl implements ProxyDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserEntity getUserProxy(long userId) {
        return em.getReference(UserEntity.class, userId);
    }
}
