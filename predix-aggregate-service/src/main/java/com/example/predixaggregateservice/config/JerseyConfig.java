package com.example.predixaggregateservice.config;

import com.example.predixaggregateservice.rest.TerminalAggregateImpl;
import org.glassfish.jersey.server.ResourceConfig;
import com.example.predixaggregateservice.helper.CorelationIdGenerator;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Created by ravipalakodeti on 7/31/17.
 */
@Component
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(TerminalAggregateImpl.class);
//        register(CorelationIdGenerator.class);
    }
}
