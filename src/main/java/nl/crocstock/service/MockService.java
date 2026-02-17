package nl.crocstock.service;

import nl.crocstock.model.IncomingRequest;
import nl.crocstock.model.MockedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MockService {

    @Autowired
    private MappingService mappingService;

    public String determineResponse(String uri) {
        var matchMe = "/match/this";
        if (uri.equalsIgnoreCase(matchMe)) {
            return "Found match for endpoint %s".formatted(uri);
        } else {
            throw new IllegalArgumentException("No match found");
        }
    }

    public MockedResponse determineResponse(IncomingRequest incomingRequest) {
        var mapping = mappingService.getMapping(incomingRequest);
        return mapping == null ? null : mapping.getMockedResponse();
    }
}
