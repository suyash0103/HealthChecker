package org.fetch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.when;

public class AvailabilityCalculatorTest {

    private AvailabilityCalculator availabilityCalculator;

    @BeforeEach
    public void setUp() {
        availabilityCalculator = new AvailabilityCalculator();
    }

    @Test
    public void testAvailabilityCalculation() {
        Request request1 = Mockito.mock(Request.class);
        Request request2 = Mockito.mock(Request.class);

        when(request1.getUrl()).thenReturn("http://example.com/endpoint1");
        when(request1.getMethod()).thenReturn("GET");
        when(request2.getUrl()).thenReturn("http://example.com/endpoint2");
        when(request2.getMethod()).thenReturn("POST");

        availabilityCalculator.updateAvailability("example.com", true);
        availabilityCalculator.updateAvailability("example.com", false);
        availabilityCalculator.updateAvailability("example.com", true);

        Assertions.assertEquals(67, availabilityCalculator.getAvailability("example.com", 2));
    }
}
