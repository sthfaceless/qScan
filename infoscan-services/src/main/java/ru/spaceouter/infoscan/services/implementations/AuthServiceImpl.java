package ru.spaceouter.infoscan.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ru.spaceouter.infoscan.dto.auth.UserAuthDTO;
import ru.spaceouter.infoscan.exceptions.UnauthorizedException;
import ru.spaceouter.infoscan.model.AuthDAO;
import ru.spaceouter.infoscan.model.entities.UserEntity;
import ru.spaceouter.infoscan.services.AuthService;

/**
 * @author danil
 * @date 21.04.19
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService<UserAuthDTO> {

    private final AuthDAO authDAO;

    /*
    * Cached method:
    * If user contains in cache then it will get from cache
    * else it will open transaction ang get from database
    * */
    @Override
    public UserAuthDTO getAuthUser(String token){

        UserEntity userEntity = getUserFromDatabase(token);

        return new UserAuthDTO(userEntity.getUserId(),
                userEntity.getLogin());
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    protected UserEntity getUserFromDatabase(String token){

      return authDAO.getByToken(token);
    }

}
