package ru.spaceouter.infoscan.model.hibernate;

import ru.spaceouter.infoscan.model.entities.user.UserEntity;

/**
 * @author danil
 * @date 22.04.19
 */
public interface ProxyDAO {

    UserEntity getUserProxy(long userId);

}
