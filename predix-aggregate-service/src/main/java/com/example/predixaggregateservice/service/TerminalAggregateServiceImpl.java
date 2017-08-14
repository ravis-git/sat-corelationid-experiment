package com.example.predixaggregateservice.service;

import com.example.predixaggregateservice.model.Terminal;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * Created by ravipalakodeti on 7/31/17.
 */
@Component
@Slf4j
public class TerminalAggregateServiceImpl implements TerminalAggregateService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Terminal getTerminalDetails() {

//        log.info("=>(3): {}", "inside service method ");

        HttpHeaders headers = new HttpHeaders();
        headers.set("transaction.id", MDC.get("transaction.id"));
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<Terminal> response = restTemplate.exchange(
                "http://predix_crud_service:8080/domain/terminal", HttpMethod.GET, entity, Terminal.class);

        return response.getBody();
    }
}
