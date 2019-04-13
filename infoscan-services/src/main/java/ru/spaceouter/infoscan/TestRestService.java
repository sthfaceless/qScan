package ru.spaceouter.infoscan;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TestRestService {

    private final Random random = new Random();


    public List<TestDTO> getGeneratedList(){

        List<TestDTO> list = new ArrayList<>(5);

        random.ints()
                .limit(5)
                .forEach(e -> list.add(
                        new TestDTO(e, String.valueOf(String.valueOf(e).hashCode()))));

        return list;
    }

}
