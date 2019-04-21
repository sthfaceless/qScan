package ru.spaceouter.infoscan.services;

import ru.spaceouter.infoscan.dto.auth.AuthDTO;
import ru.spaceouter.infoscan.dto.auth.CreateUserDTO;
import ru.spaceouter.infoscan.dto.auth.RestoreDTO;
import ru.spaceouter.infoscan.model.entities.user.UserEntity;

/**
 * @author danil
 * @date 20.04.19
 */
public interface UserService {

    void auth(AuthDTO authDTO);

    void createUser(CreateUserDTO createUserDTO);

    UserEntity getUserByUsername(String username);

    void activateUser(String uuid);

    void restore(RestoreDTO restoreDTO);

    void confirmRestore(String uuid);

    void logout(long userId);

}
