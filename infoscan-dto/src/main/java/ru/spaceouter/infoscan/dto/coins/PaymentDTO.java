package ru.spaceouter.infoscan.dto.coins;

import lombok.*;

import java.util.Date;

/**
 * @author danil
 * @date 20.04.19
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private long id;
    private long quantity;
    private Date date;
    private String service;

}
