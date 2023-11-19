package org.fetch;

public class Utils {

    // Extract the domain from a url. Works with http as well as https urls.
    // https://www.xyz.com/path --> returns www.xyz.com
    // http://xyz.com/ --> returns xyz.com
    public static String getDomain(String url) {
        int i = 0;
        int startPos = 0;
        for (i = 0; i < url.length(); i++) {
            if (url.charAt(i) == ':' && url.charAt(i + 1) == '/' && url.charAt(i + 2) == '/') {
                i += 3;
                startPos = i;
                break;
            }
        }

        while(i < url.length() && url.charAt(i) != '/') {
            i++;
        }

        return url.substring(startPos, i);
    }

    // Check if a domain is UP as per given conditions
    public static boolean isDomainUp(long latency, int responseCode) {
        return latency < Constants.latencyThreshold && responseCode >= Constants.responseCodeLowerThreshold &&
                responseCode <= Constants.responseCodeUpperThreshold;
    }

}
