package ru.spaceouter.infoscan.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.spaceouter.infoscan.dto.support.CreateQuestionDTO;
import ru.spaceouter.infoscan.services.SupportService;

/**
 * @author danil
 * @date 20.04.19
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SupportServiceImpl implements SupportService {

    @Override
    public void createQuestion(long userId, CreateQuestionDTO createQuestionDTO) {

    }

}
