package ru.spaceouter.infoscan.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.spaceouter.infoscan.dto.auth.UserAuthDTO;
import ru.spaceouter.infoscan.model.AuthSpringDAO;
import ru.spaceouter.infoscan.model.entities.user.AuthEntity;
import ru.spaceouter.infoscan.services.AuthService;

/**
 * @author danil
 * @date 21.04.19
 */
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService<UserAuthDTO> {

    private final AuthSpringDAO authSpringDAO;

    /*
    * Cached method:
    * If user contains in cache then it will get from cache
    * else it will open transaction ang get from database
    * */
    @Override
    @Cacheable(cacheNames = "authentications", key = "#token")
    public UserAuthDTO getAuthUser(String token){

        AuthEntity authEntity = getUserFromDatabase(token);

        return new UserAuthDTO(authEntity.getAuthId(),
                authEntity.getUsername());
    }

    @CachePut(cacheNames = "authentications", key = "#token")
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public AuthEntity getUserFromDatabase(String token){

      return authSpringDAO.getByToken(token);
    }

}
