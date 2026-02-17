package nl.crocstock.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import nl.crocstock.mapper.JsonMapper;
import nl.crocstock.model.IncomingRequest;
import nl.crocstock.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EntryPointController {

    @Autowired
    private MockService mockService;

    @RequestMapping(value = "/**", produces = "text/plain")
    @ResponseBody
    public ResponseEntity<String> intercept(HttpServletRequest httpServletRequest, @RequestBody(required = false) Object requestBody) {
        var incoming = new IncomingRequest(httpServletRequest.getMethod(), httpServletRequest.getRequestURI(), httpServletRequest.getQueryString(), requestBody);
        log.info(incoming.getUri());
        log.info(incoming.getHttpMethod());
        log.info(JsonMapper.toJsonString(incoming.getRequestBody()));
        var response = mockService.determineResponse(incoming);
        if (response == null) {
            return new ResponseEntity<>("Mapping not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(JsonMapper.toJsonString(response), HttpStatus.valueOf(response.getStatus()));
        }
    }

}
