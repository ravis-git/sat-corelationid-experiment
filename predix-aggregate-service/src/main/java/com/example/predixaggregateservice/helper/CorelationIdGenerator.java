package com.example.predixaggregateservice.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by ravipalakodeti on 1/19/17.
 */
@Provider
@Slf4j
public class CorelationIdGenerator implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        String corelationId = UUID.randomUUID().toString();
        requestContext.getHeaders().add("CorelationId", corelationId);
        requestContext.getHeaders().add("RequestTime", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        log.info("==== > Corelation id: {} ", corelationId);
    }
}
