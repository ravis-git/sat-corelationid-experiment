package com.example.predixcrudservice.rest;

import com.example.predixcrudservice.model.Terminal;

import javax.ws.rs.core.HttpHeaders;

/**
 * Created by ravipalakodeti on 7/28/17.
 */
public interface TerminalService {

    public Terminal getTerminalDetails(HttpHeaders httpHeaders);
}
