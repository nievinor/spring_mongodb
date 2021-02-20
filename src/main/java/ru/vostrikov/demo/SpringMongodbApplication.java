package ru.vostrikov.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.vostrikov.demo.da.JsonSerializeReader;
import ru.vostrikov.demo.entity.JsonFileClass;

import java.io.IOException;

@SpringBootApplication
public class SpringMongodbApplication implements CommandLineRunner {


    @Autowired
    private JsonFileClassRepository repository;

    @Autowired
    JsonSerializeReader jsonSerializeReader;


//    private final JsonFileClassRepository repository;
//
//    private final JsonSerializeReader jsonSerializeReader;
//
//    @Autowired
//    public SpringMongodbApplication(JsonFileClassRepository repository, JsonSerializeReader jsonSerializeReader) {
//        this.repository = repository;
//        this.jsonSerializeReader = jsonSerializeReader;
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws IOException {
        String SOURCE_FILE = "parameters.json";

        //log

        JsonFileClass json = jsonSerializeReader.read(SOURCE_FILE);

        repository.deleteAll();
        repository.save(json);

        for (JsonFileClass dataFromDB : repository.findAll()) System.out.println(dataFromDB);

    }

}
