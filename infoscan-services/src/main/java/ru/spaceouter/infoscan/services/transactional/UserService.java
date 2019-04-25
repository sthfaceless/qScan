package ru.spaceouter.infoscan.services.transactional;

import ru.spaceouter.infoscan.dto.view.user.CreateUserDTO;
import ru.spaceouter.infoscan.dto.view.auth.RestoreDTO;

/**
 * @author danil
 * @date 20.04.19
 */
public interface UserService {

    void createUser(CreateUserDTO createUserDTO);

    boolean activateUser(String uuid);

    void restore(String email);

    boolean confirmRestore(RestoreDTO restoreDTO);

    boolean existEmail(String email);

    boolean existUsername(String username);

}
