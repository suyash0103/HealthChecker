package org.fetch;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Parser {

    public List<Request> parseYAML(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

            return objectMapper.readValue(new File(filePath),
                    new TypeReference<>() {
                    });
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (JsonMappingException e) {
            System.out.println("Incorrect YAML format: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }

        return null;
    }

}
