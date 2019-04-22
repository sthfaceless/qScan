package ru.spaceouter.infoscan.model;

/**
 * @author danil
 * @date 22.04.19
 */
public interface ActivateCustomDAO {

    boolean activateAccount(String uuid);

    boolean confirmPassword(String uuid, String password);

    boolean setConfirmPasswordToken(String uuid, String email);

    boolean confirmEmail(String uuid);

    boolean setConfirmEmailToken(long userId, String uuid, String email);

}
