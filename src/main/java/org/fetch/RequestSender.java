package org.fetch;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RequestSender {

    private final AvailabilityCalculator availabilityCalculator;

    public RequestSender() {
        availabilityCalculator = new AvailabilityCalculator();
    }

    public void sendRequests(List<Request> requestList) {
        while(true) {
            // Thread pool with size of requestList list
            ExecutorService executorService = Executors.newFixedThreadPool(requestList.size());

            // Run the sendRequest function for every thread
            for (Request request : requestList) {
                executorService.submit(() -> sendRequest(request));
            }

            executorService.shutdown();
            try {
                executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }

            availabilityCalculator.logAvailability();

            // Wait for 15 seconds before sending next round of requests
            try {
                TimeUnit.SECONDS.sleep(Constants.requestSenderTimeout);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void sendRequest(Request request) {
        try {
            long startTime = System.currentTimeMillis();

            URL url = new URL(request.getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            String method = request.getMethod() != null ? request.getMethod() : "GET";
            connection.setRequestMethod(method);

            if (request.getHeaders() != null) {
                for (String key : request.getHeaders().keySet()) {
                    connection.setRequestProperty(key, request.getHeaders().get(key));
                }
            }

            if (request.getBody() != null && !request.getBody().isEmpty() && !method.equals("GET")) {
                connection.setDoOutput(true);
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = request.getBody().getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
            }

            int responseCode = connection.getResponseCode();

            long endTime = System.currentTimeMillis();
            long latency = endTime - startTime;
//            System.out.println(Utils.getDomain(request.getUrl())
//                    + " " + latency + " " + responseCode + " " + Utils.isDomainUp(latency, responseCode));

            availabilityCalculator.updateAvailability(Utils.getDomain(request.getUrl()),
                    Utils.isDomainUp(latency, responseCode));

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
