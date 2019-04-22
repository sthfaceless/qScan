package ru.spaceouter.infoscan.services;

import javax.mail.MessagingException;

/**
 * @author danil
 * @date 21.04.19
 */
public interface EmailService {

    boolean sendActivateAccountMessage(String email, String activateString) throws MessagingException;

    boolean sendConfirmEmailMessage(String email, String activateString) throws MessagingException;

    boolean sendConfirmPasswordRestoreMessage(String email, String activateString) throws MessagingException;

}
