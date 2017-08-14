package com.example.predixcrudservice.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import com.example.predixcrudservice.rest.TerminalServiceImpl;

import javax.ws.rs.ApplicationPath;

/**
 * Created by ravipalakodeti on 7/28/17.
 */
@Component
@ApplicationPath("domain")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(TerminalServiceImpl.class);
    }
}
