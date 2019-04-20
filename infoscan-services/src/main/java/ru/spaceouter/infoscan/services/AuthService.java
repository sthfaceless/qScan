package ru.spaceouter.infoscan.services;

import ru.spaceouter.infoscan.dto.auth.CreateUserDTO;
import ru.spaceouter.infoscan.dto.auth.RestoreDTO;

/**
 * @author danil
 * @date 20.04.19
 */
public interface AuthService {

    void createUser(CreateUserDTO createUserDTO);

    void activateUser(String uuid);

    void restore(RestoreDTO restoreDTO);

    void confirmRestore(String uuid);

    void logout();

}
