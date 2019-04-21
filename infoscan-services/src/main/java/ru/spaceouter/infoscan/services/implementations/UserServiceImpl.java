package ru.spaceouter.infoscan.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.spaceouter.infoscan.dto.auth.AuthDTO;
import ru.spaceouter.infoscan.dto.auth.CreateUserDTO;
import ru.spaceouter.infoscan.dto.auth.RestoreDTO;
import ru.spaceouter.infoscan.dto.auth.Role;
import ru.spaceouter.infoscan.model.AuthSpringDAO;
import ru.spaceouter.infoscan.model.UserSpringDAO;
import ru.spaceouter.infoscan.model.entities.user.AuthEntity;
import ru.spaceouter.infoscan.model.entities.user.RoleEntity;
import ru.spaceouter.infoscan.model.entities.user.UserEntity;
import ru.spaceouter.infoscan.services.UserService;
import ru.spaceouter.infoscan.services.simple.TokenService;

import java.util.Date;

/**
 * @author danil
 * @date 20.04.19
 */
@Service
@AllArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    private final UserSpringDAO userSpringDAO;
    private final AuthSpringDAO authSpringDAO;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenService tokenService;

    @Override
    public void auth(AuthDTO authDTO) {

    }

    @Override
    public void createUser(CreateUserDTO createUserDTO) {

        final UserEntity userEntity = new UserEntity(
                createUserDTO.getLogin(),
                createUserDTO.getEmail(),
                new Date());

        final RoleEntity roleEntity = new RoleEntity(Role.USER);

        final AuthEntity authEntity = new AuthEntity(
                createUserDTO.getLogin(),
                bCryptPasswordEncoder.encode(createUserDTO.getPassword()),
                tokenService.nextToken(),
                roleEntity
        );
        authEntity.setUser(userEntity);

        roleEntity.setAuth(authEntity);
        userEntity.setAuth(authEntity);

        userSpringDAO.save(userEntity);
    }

    @Override
    public UserEntity getUserByUsername(String username) {

        return userSpringDAO.findByUsername(username);
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
