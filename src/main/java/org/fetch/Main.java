package org.fetch;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter the filepath as a command line argument");
            return;
        }

        if (args.length > 1) {
            System.out.println("Extra command line arguments entered");
            return;
        }

        Parser parser = new Parser();
        // Get the list of requests present in the yaml file
        List<Request> requestList = parser.parseYAML(args[0]);
        if (requestList != null) {
            RequestSender requestSender = new RequestSender();
            // Send the requests
            requestSender.sendRequests(requestList);
        }
    }
}