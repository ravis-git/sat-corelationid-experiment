package com.example.predixaggregateservice.helper;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by ravipalakodeti on 8/1/17.
 */
@Aspect
@Component
@Slf4j
public class MDCLogHelperAspect {

    @Before(
        "execution(* com.example.predixaggregateservice.rest.TerminalAggregateImpl.getTerminalDetails(javax.ws.rs.container.AsyncResponse))")
    public void setCorelationIdInMDC() {
        MDC.put("transaction.id", "t.id=="+UUID.randomUUID().toString());
    }

    @After(
            "execution(* com.example.predixaggregateservice.rest.TerminalAggregateImpl.getTerminalDetails(javax.ws.rs.container.AsyncResponse))")
    public void removeCorelationIdInMDC() {
        MDC.clear();
    }

}
