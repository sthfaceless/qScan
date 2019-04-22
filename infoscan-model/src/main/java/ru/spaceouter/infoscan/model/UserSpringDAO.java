package ru.spaceouter.infoscan.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.spaceouter.infoscan.model.entities.user.UserEntity;

/**
 * @author danil
 * @date 21.04.19
 */
@Repository
public interface UserSpringDAO extends CrudRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}
