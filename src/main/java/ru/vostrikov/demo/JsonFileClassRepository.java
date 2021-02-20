package ru.vostrikov.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.vostrikov.demo.entity.JsonFileClass;

public interface JsonFileClassRepository extends MongoRepository<JsonFileClass, String> {
}
