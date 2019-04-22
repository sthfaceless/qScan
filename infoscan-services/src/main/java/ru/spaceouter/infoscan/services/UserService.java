package ru.spaceouter.infoscan.services;

import ru.spaceouter.infoscan.dto.view.CreateUserDTO;
import ru.spaceouter.infoscan.dto.view.RestoreDTO;
import ru.spaceouter.infoscan.dto.view.StartRestoreDTO;
import ru.spaceouter.infoscan.model.entities.user.UserEntity;

import javax.mail.MessagingException;

/**
 * @author danil
 * @date 20.04.19
 */
public interface UserService {

    void createUser(CreateUserDTO createUserDTO) throws MessagingException;

    UserEntity getUserByUsername(String username);

    boolean activateUser(String uuid);

    void restore(StartRestoreDTO startRestoreDTO) throws MessagingException;

    boolean confirmRestore(RestoreDTO restoreDTO);

    boolean existEmail(String email);

    boolean existUsername(String username);

}
