package ru.spaceouter.infoscan.services;

import ru.spaceouter.infoscan.dto.coins.PaymentDTO;

import java.util.List;

/**
 * @author danil
 * @date 20.04.19
 */
public interface CoinsService {

    int getCoinsSize();

    List<PaymentDTO> getPaymentsHistory();

    void requestPayment();

}
