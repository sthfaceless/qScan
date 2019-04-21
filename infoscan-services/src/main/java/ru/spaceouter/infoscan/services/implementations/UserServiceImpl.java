package ru.spaceouter.infoscan.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.spaceouter.infoscan.dto.auth.AuthDTO;
import ru.spaceouter.infoscan.dto.auth.CreateUserDTO;
import ru.spaceouter.infoscan.dto.auth.RestoreDTO;
import ru.spaceouter.infoscan.model.AuthDAO;
import ru.spaceouter.infoscan.services.UserService;

/**
 * @author danil
 * @date 20.04.19
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    private final AuthDAO authDAO;

    public UserServiceImpl(AuthDAO authDAO) {
        this.authDAO = authDAO;
    }


    @Override
    public void auth(AuthDTO authDTO) {

    }

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
    public void logout(long userId) {

    }
}
