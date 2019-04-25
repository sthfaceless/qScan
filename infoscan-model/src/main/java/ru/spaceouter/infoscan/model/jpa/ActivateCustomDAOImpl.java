package ru.spaceouter.infoscan.model.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.spaceouter.infoscan.model.ActivateCustomDAO;
import ru.spaceouter.infoscan.model.entities.user.ActivationEntity;
import ru.spaceouter.infoscan.model.entities.user.AuthEntity;
import ru.spaceouter.infoscan.model.entities.user.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author danil
 * @date 22.04.19
 */
@Repository
@Transactional
public class ActivateCustomDAOImpl implements ActivateCustomDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean activateAccount(String uuid) {
        return em.createNamedQuery(ActivationEntity.ACTIVATE_ACCOUNT)
                .setParameter("str", uuid)
                .executeUpdate() != 0;
    }

    @Override
    public boolean confirmPassword(String uuid, String password) {
        return em.createNamedQuery(ActivationEntity.CONFIRM_PASSWORD)
                .setParameter("str", uuid)
                .setParameter("pass", password)
                .executeUpdate() != 0;
    }


    @Override
    public boolean confirmEmail(String uuid) {
        return em.createNamedQuery(ActivationEntity.CONFIRM_EMAIL)
                .setParameter("str", uuid)
                .executeUpdate() != 0;
    }

    @Override
    public boolean setConfirmPasswordToken(String uuid, String email) {

        long authId = em.createNamedQuery(AuthEntity.GET_AUTH_BY_EMAIL, Long.class)
                .setParameter("email", email)
                .getResultList().stream().findFirst().orElse((long) -1);
        if(authId == -1)
            return false;

        return  em.createNamedQuery(ActivationEntity.SET_CONFIRM_PASSWORD_TOKEN)
                .setParameter("uuid", uuid)
                .setParameter("auth", em.getReference(AuthEntity.class, authId))
                .executeUpdate() != 0;

    }

    @Override
    public boolean setConfirmEmailToken(long userId, String uuid, String email) {

        long authId = em.createNamedQuery(AuthEntity.GET_AUTH_BY_USER_ID, Long.class)
                .setParameter("user", em.getReference(UserEntity.class, userId))
                .getResultList().stream().findFirst().orElse((long) -1);
        if(authId == -1)
            return false;

        return em.createNamedQuery(ActivationEntity.SET_CONFIRM_EMAIL_TOKEN)
                .setParameter("uuid", uuid)
                .setParameter("email", email)
                .setParameter("auth", em.getReference(AuthEntity.class, authId))
                .executeUpdate() != 0;
    }
}
