package ru.spaceouter.infoscan.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.spaceouter.infoscan.dto.model.AuthModelDTO;
import ru.spaceouter.infoscan.model.entities.user.AuthEntity;
import ru.spaceouter.infoscan.model.entities.user.UserEntity;

import java.util.Date;

/**
 * @author danil
 * @date 20.04.19
 */
@Repository
public interface AuthSpringDAO extends CrudRepository<AuthEntity, Long> {

    AuthEntity findByToken(String token);

    @Query("select new ru.spaceouter.infoscan.dto.auth.AuthModelDTO(ae.authId, ae.username, ae.password, ae.token, ae.active, u.userId)" +
            " from AuthEntity ae " +
            " left join ae.user u " +
            " where ae.token = :token and ae.expiredDate > :date")
    AuthModelDTO findByTokenAndExpiredDateAfter(@Param("token") String token, @Param("date") Date expiredDate);

    @Query("select new ru.spaceouter.infoscan.dto.auth.AuthModelDTO(ae.authId, ae.username, ae.password, ae.token, ae.active, u.userId)" +
            " from AuthEntity ae " +
            " left join ae.user u " +
            " where ae.username = :username")
    AuthModelDTO findByUsername(@Param("username") String username);

    void updateByIdTokenAndExpiredDate(long id, String token, Date expiredDate);

    @Query("update AuthEntity set expiredDate=current_time where token = :token")
    void deleteToken(@Param("token") String token);

    @Query("update AuthEntity set password = :pass where user = :user")
    void updatePassword(@Param("pass") String pass, @Param("user") UserEntity user);

    @Query("select password from AuthEntity  where user = :user")
    String getPasswordByUser(@Param("user") UserEntity user);
}
