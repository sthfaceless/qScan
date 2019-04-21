package ru.spaceouter.infoscan.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spaceouter.infoscan.model.entities.UserEntity;

/**
 * @author danil
 * @date 20.04.19
 */
@Repository
public interface AuthDAO extends CrudRepository<UserEntity, Long> {

    UserEntity getByToken(String token);

}
