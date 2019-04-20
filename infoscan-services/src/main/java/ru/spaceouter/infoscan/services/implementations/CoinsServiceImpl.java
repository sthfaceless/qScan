package ru.spaceouter.infoscan.services.implementations;

import org.springframework.stereotype.Service;
import ru.spaceouter.infoscan.dto.coins.PaymentDTO;
import ru.spaceouter.infoscan.services.CoinsService;

import java.util.List;

/**
 * @author danil
 * @date 20.04.19
 */
@Service
public class CoinsServiceImpl implements CoinsService {

    @Override
    public int getCoinsSize() {
        return 0;
    }

    @Override
    public List<PaymentDTO> getPaymentsHistory() {
        return null;
    }

    @Override
    public void requestPayment() {

    }
}
