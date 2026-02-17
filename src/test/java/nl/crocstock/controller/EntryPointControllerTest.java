package nl.crocstock.controller;

import nl.crocstock.service.MockService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class EntryPointControllerTest {

    @InjectMocks
    private EntryPointController entryPointController;

    @Mock
    private MockService mockService;


    @Test
    void intercept() {
    }
}