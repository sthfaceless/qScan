package ru.spaceouter.infoscan;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/rest")
public class TestRest {

    private final TestRestService service;

    public TestRest(TestRestService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TestDTO> getList(){

        return service.getGeneratedList();
    }

}
