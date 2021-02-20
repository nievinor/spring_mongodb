package ru.vostrikov.demo.da;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;
import ru.vostrikov.demo.entity.JsonFileClass;

import java.io.File;
import java.io.IOException;

@Component
public class JsonSerializeReader {
    public JsonFileClass read(String url) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(url), JsonFileClass.class);
    }
}
