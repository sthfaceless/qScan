package ru.spaceouter.infoscan.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.spaceouter.infoscan.dto.coins.PaymentDTO;
import ru.spaceouter.infoscan.services.CoinsService;

import java.util.List;

/**
 * @author danil
 * @date 20.04.19
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CoinsServiceImpl implements CoinsService {

    @Transactional(readOnly = true)
    @Override
    public int getCoinsSize() {
        return 0;
    }

    @Transactional(readOnly = true)
    @Override
    public List<PaymentDTO> getPaymentsHistory() {
        return null;
    }

    @Override
    public void requestPayment() {

    }
}
