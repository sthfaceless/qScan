package ru.spaceouter.infoscan.services;

import ru.spaceouter.infoscan.dto.coins.PaymentDTO;

import java.util.List;

/**
 * @author danil
 * @date 20.04.19
 */
public interface CoinsService {

    long getCoinsSize(long userId);

    List<PaymentDTO> getPaymentsHistory(long userId);

    void requestPayment(long userId);

}
