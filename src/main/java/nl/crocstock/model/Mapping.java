package nl.crocstock.model;

import lombok.Data;

@Data
public class Mapping {
    private IncomingRequest request;
    private MockedResponse mockedResponse;
}
