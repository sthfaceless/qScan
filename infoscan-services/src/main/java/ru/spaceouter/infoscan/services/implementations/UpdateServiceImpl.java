package ru.spaceouter.infoscan.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.spaceouter.infoscan.services.UpdateService;

/**
 * @author danil
 * @date 20.04.19
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UpdateServiceImpl implements UpdateService {

    @Override
    public void updateEmail(long userId, String email) {

    }

    @Override
    public void confirmEmailUpdating(String uuid) {

    }

    @Override
    public void updatePassword(long userId, String pass) {

    }
}
