package ru.spaceouter.infoscan.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author danil
 * @date 21.04.19
 */
@Service
@AllArgsConstructor
public class EmailServiceImpl {

    private final JavaMailSender javaMailSender;

}
