package org.fetch;

public class Utils {

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

    public static boolean isDomainUp(long latency, int responseCode) {
        return latency < Constants.latencyThreshold && responseCode >= Constants.responseCodeLowerThreshold &&
                responseCode <= Constants.responseCodeUpperThreshold;
    }

}
