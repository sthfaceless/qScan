package ru.spaceouter.infoscan.services;

import javax.mail.MessagingException;

/**
 * @author danil
 * @date 20.04.19
 */
public interface UpdateService {

    void updateEmail(long userId, String email) throws MessagingException;

    boolean confirmEmailUpdating(String uuid);

    boolean updatePassword(long userId, String pass, String newPass);

}
