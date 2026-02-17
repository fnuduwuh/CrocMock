package nl.crocstock.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class IncomingRequest {

    private String httpMethod;
    private String uri;
    private String queryParameters;
    private Object requestBody; // TODO generics
}
