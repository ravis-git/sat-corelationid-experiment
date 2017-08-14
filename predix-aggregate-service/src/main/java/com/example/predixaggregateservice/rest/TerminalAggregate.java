package com.example.predixaggregateservice.rest;

import com.example.predixaggregateservice.model.Terminal;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;

/**
 * Created by ravipalakodeti on 7/31/17.
 */
public interface TerminalAggregate {

    public void getTerminalDetails(AsyncResponse asyncResponse);

    public void getTerminalDetailsUsingNewThread(@Suspended final AsyncResponse asyncResponse);
}
