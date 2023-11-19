package org.fetch;

import java.util.HashMap;
import java.util.Map;

public class AvailabilityCalculator {

    private Map<String, Integer> domainAvailabilityMap;

    public AvailabilityCalculator() {
        domainAvailabilityMap = new HashMap<>();
    }

    public void updateAvailability(String domain, boolean isDomainUp) {
        int numberOfUps = domainAvailabilityMap.getOrDefault(domain, 0);
        numberOfUps += isDomainUp ? 1 : 0;
        domainAvailabilityMap.put(domain, numberOfUps);
    }

    public void logAvailability(Map<String, Integer> requestsCounterMap) {
        for (Map.Entry<String, Integer> entry: domainAvailabilityMap.entrySet()) {
            double availabilityDouble = 100.0 * (double) entry.getValue() / requestsCounterMap.get(entry.getKey());
            long availability = Math.round(availabilityDouble);
            System.out.println(entry.getKey() + " has " + availability + "% availability percentage");
        }
        System.out.println();
    }

}
