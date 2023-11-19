package org.fetch;

import java.util.HashMap;
import java.util.Map;

public class AvailabilityCalculator {

    // Maintain the number of times a domain was UP
    private Map<String, Integer> domainAvailabilityMap;

    // Maintain the number of times an HTTP request was sent to a domain
    private Map<String, Integer> requestsCounterMap;

    public AvailabilityCalculator() {
        domainAvailabilityMap = new HashMap<>();
        requestsCounterMap = new HashMap<>();
    }

    public void updateAvailability(String domain, boolean isDomainUp) {
        int numberOfRequests = requestsCounterMap.getOrDefault(domain, 0);
        numberOfRequests++;
        requestsCounterMap.put(domain, numberOfRequests);

        int numberOfUps = domainAvailabilityMap.getOrDefault(domain, 0);
        numberOfUps += isDomainUp ? 1 : 0;
        domainAvailabilityMap.put(domain, numberOfUps);
    }

    public long getAvailability(String domain, int numberOfUps) {
        double availabilityDouble = 100.0 * (double) numberOfUps / requestsCounterMap.get(domain);
        return Math.round(availabilityDouble);
    }

    public void logAvailability() {
        for (Map.Entry<String, Integer> entry: domainAvailabilityMap.entrySet()) {
            System.out.println(entry.getKey() + " has " + getAvailability(entry.getKey(), entry.getValue())
                    + "% availability percentage");
        }
        System.out.println();
    }

}
