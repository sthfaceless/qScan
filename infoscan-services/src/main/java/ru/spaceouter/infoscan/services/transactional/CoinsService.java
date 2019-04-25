package ru.spaceouter.infoscan.services.transactional;

import ru.spaceouter.infoscan.dto.view.coins.CoinsDTO;
import ru.spaceouter.infoscan.dto.view.coins.PaymentDTO;

import java.util.List;

/**
 * @author danil
 * @date 20.04.19
 */
public interface CoinsService {

    CoinsDTO getCoinsSize(long userId);

    List<PaymentDTO> getPaymentsHistory(long userId);

    void requestPayment(long userId);

}
