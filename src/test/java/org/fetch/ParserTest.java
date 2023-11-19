package org.fetch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ParserTest {

    @Test
    public void testValidYamlParsing() {
        Parser parser = new Parser();
        String filePath = "/Applications/healthchecker/HealthChecker/request.yaml";

        List<Request> requestList = parser.parseYAML(filePath);

        Assertions.assertNotNull(requestList);
    }

    @Test
    public void testNonExistentYamlParsing() {
        Parser parser = new Parser();
        String filePath = "/Applications/request.yaml";

        List<Request> requestList = parser.parseYAML(filePath);

        Assertions.assertNull(requestList);
    }

    @Test
    public void testInvalidYamlParsing() {
        Parser parser = new Parser();
        String filePath = "/Applications/healthchecker/HealthChecker/invalidrequestfile.yaml";

        List<Request> requestList = parser.parseYAML(filePath);

        Assertions.assertNull(requestList);
    }
}
