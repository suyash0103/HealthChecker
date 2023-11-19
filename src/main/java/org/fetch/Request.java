package org.fetch;

import java.util.Map;

public class Request {

    private Map<String, String> headers;

    private String method;

    private String name;

    private String url;

    private String body;

    public Request() {
    }

    public Request(Map<String, String> headers, String method, String name, String url, String body) {
        this.headers = headers;
        this.method = method;
        this.name = name;
        this.url = url;
        this.body = body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Request{" +
                "headers=" + headers +
                ", method='" + method + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
