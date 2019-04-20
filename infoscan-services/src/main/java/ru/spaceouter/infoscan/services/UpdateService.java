package ru.spaceouter.infoscan.services;

/**
 * @author danil
 * @date 20.04.19
 */
public interface UpdateService {

    void updateEmail(String email);

    void confirmEmailUpdating(String uuid);

    void updatePassword(String pass);

}
