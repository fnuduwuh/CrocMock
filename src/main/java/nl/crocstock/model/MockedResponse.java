package nl.crocstock.model;

import lombok.Data;

import java.util.Map;

@Data
public class MockedResponse {
    private int status;
    private Map<String, String> headers;
    private Object body;
}
