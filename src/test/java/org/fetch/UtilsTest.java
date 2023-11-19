package org.fetch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    @Test
    public void testGetDomain() {
        String domain1 = Utils.getDomain("https://www.example.com/path");
        String domain2 = Utils.getDomain("http://example.com/");
        String domain3 = Utils.getDomain("https://sub.example.com/page");

        Assertions.assertEquals("www.example.com", domain1);
        Assertions.assertEquals("example.com", domain2);
        Assertions.assertEquals("sub.example.com", domain3);
    }

    @Test
    public void testIsDomainUp() {
        boolean upCase = Utils.isDomainUp(10, 200);
        boolean thresholdCase = Utils.isDomainUp(500, 400);
        boolean downCase = Utils.isDomainUp(20, 404);

        Assertions.assertTrue(upCase);
        Assertions.assertFalse(thresholdCase);
        Assertions.assertFalse(downCase);
    }
}
