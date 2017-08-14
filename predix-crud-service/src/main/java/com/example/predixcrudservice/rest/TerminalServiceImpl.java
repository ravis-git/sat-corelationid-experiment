package com.example.predixcrudservice.rest;

import com.example.predixcrudservice.model.Terminal;
import com.example.predixcrudservice.repository.TerminalRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * Created by ravipalakodeti on 7/28/17.
 */
@Component
@Path("/")
@Slf4j
public class TerminalServiceImpl implements TerminalService {

    @Autowired
    TerminalRepository terminalRepository;

    @Override
    @GET
    @Path("terminal")
    @Produces(MediaType.APPLICATION_JSON)
    public Terminal getTerminalDetails(@Context HttpHeaders headers) {
        MDC.put("transaction.id", ""+headers.getHeaderString("transaction.id"));
//        log.info("=>(4): {}", "inside crud service method");
        return terminalRepository.getTerminalDetails();
    }
}
