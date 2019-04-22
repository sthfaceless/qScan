package ru.spaceouter.infoscan.model.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.spaceouter.infoscan.model.ActivateCustomDAO;
import ru.spaceouter.infoscan.model.entities.user.ActivationEntity;
import ru.spaceouter.infoscan.model.entities.user.AuthEntity;
import ru.spaceouter.infoscan.model.entities.user.UserEntity;

/**
 * @author danil
 * @date 22.04.19
 */
@Repository
public class ActivateCustomDAOImpl extends AbstractHibernateDAO implements ActivateCustomDAO {

    public ActivateCustomDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public boolean activateAccount(String uuid) {
        return session().createNamedQuery(ActivationEntity.ACTIVATE_ACCOUNT)
                .setParameter("str", uuid)
                .executeUpdate() != 0;
    }

    @Override
    public boolean confirmPassword(String uuid, String password) {
        return session().createNamedQuery(ActivationEntity.CONFIRM_PASSWORD)
                .setParameter("str", uuid)
                .setParameter("pass", password)
                .executeUpdate() != 0;
    }


    @Override
    public boolean confirmEmail(String uuid) {
        return session().createNamedQuery(ActivationEntity.CONFIRM_EMAIL)
                .setParameter("str", uuid)
                .executeUpdate() != 0;
    }

    @Override
    public boolean setConfirmPasswordToken(String uuid, String email) {

        Session session = session();

        long authId = session.createNamedQuery(AuthEntity.GET_AUTH_BY_EMAIL, Long.class)
                .setParameter("email", email)
                .getResultList().stream().findFirst().orElse((long) -1);
        if(authId == -1)
            return false;

        return  session.createNamedQuery(ActivationEntity.SET_CONFIRM_PASSWORD_TOKEN)
                .setParameter("uuid", uuid)
                .setParameter("auth", session.load(AuthEntity.class, authId))
                .executeUpdate() != 0;

    }

    @Override
    public boolean setConfirmEmailToken(long userId, String uuid, String email) {

        Session session = session();

        long authId = session.createNamedQuery(AuthEntity.GET_AUTH_BY_USER_ID, Long.class)
                .setParameter("user", session.load(UserEntity.class, userId))
                .getResultList().stream().findFirst().orElse((long) -1);
        if(authId == -1)
            return false;

        return session.createNamedQuery(ActivationEntity.SET_CONFIRM_EMAIL_TOKEN)
                .setParameter("uuid", uuid)
                .setParameter("email", email)
                .setParameter("auth", session.load(AuthEntity.class, authId))
                .executeUpdate() != 0;
    }
}
