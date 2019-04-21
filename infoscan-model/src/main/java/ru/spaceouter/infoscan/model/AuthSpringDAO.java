package ru.spaceouter.infoscan.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spaceouter.infoscan.model.entities.user.AuthEntity;

/**
 * @author danil
 * @date 20.04.19
 */
@Repository
public interface AuthSpringDAO extends CrudRepository<AuthEntity, Long> {

    AuthEntity getByToken(String token);

}
