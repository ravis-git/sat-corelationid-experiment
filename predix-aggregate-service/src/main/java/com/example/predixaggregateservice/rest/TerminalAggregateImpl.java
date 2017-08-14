package com.example.predixaggregateservice.rest;

import com.example.predixaggregateservice.service.*;
import jersey.repackaged.com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.process.JerseyProcessingUncaughtExceptionHandler;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ravipalakodeti on 7/31/17.
 */
@Component
@Path("/")
@Slf4j
public class TerminalAggregateImpl implements TerminalAggregate{

    @Autowired
    TerminalAggregateService terminalAggregateServiceImpl;

    private static final ExecutorService QUEUE_EXECUTOR = Executors.newCachedThreadPool(new ThreadFactoryBuilder()
            .setNameFormat("async-rest-executor-%d")
            .setUncaughtExceptionHandler(new JerseyProcessingUncaughtExceptionHandler())
            .build());

    @GET
    @Path("terminal-executor")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void getTerminalDetails(@Suspended final AsyncResponse asyncResponse) {
        String uuid = UUID.randomUUID().toString();
        MDC.put("transaction.id", " t.id="+uuid);
        Instant start = Instant.now();

        QUEUE_EXECUTOR.submit(new Runnable() {
              @Override
              public void run() {
                  MDC.put("transaction.id", " t.id=="+uuid);
                  asyncResponse.resume(terminalAggregateServiceImpl.getTerminalDetails());
                  log.info("Duration: {}", ChronoUnit.MILLIS.between(start,Instant.now()));
              }
        });
    }

    @GET
    @Path("terminal-newthread")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void getTerminalDetailsUsingNewThread(@Suspended final AsyncResponse asyncResponse) {
        String uuid = UUID.randomUUID().toString();
        Instant start = Instant.now();
        new Thread(() -> {
            MDC.put("transaction.id", " t.id=="+uuid);
            asyncResponse.resume(terminalAggregateServiceImpl.getTerminalDetails());
            log.info("Duration: {}", ChronoUnit.MILLIS.between(start,Instant.now()));
        }).start();
    }
}
