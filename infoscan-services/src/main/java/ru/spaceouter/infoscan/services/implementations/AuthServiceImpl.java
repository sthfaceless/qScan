package ru.spaceouter.infoscan.services.implementations;

import org.springframework.stereotype.Service;
import ru.spaceouter.infoscan.dto.auth.CreateUserDTO;
import ru.spaceouter.infoscan.dto.auth.RestoreDTO;
import ru.spaceouter.infoscan.services.AuthService;

/**
 * @author danil
 * @date 20.04.19
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public void createUser(CreateUserDTO createUserDTO) {

    }

    @Override
    public void activateUser(String uuid) {

    }

    @Override
    public void restore(RestoreDTO restoreDTO) {

    }

    @Override
    public void confirmRestore(String uuid) {

    }

    @Override
    public void logout() {

    }
}
