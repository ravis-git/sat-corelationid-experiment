package com.example.predixaggregateservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

/**
 * Created by ravipalakodeti on 7/31/17.
 */
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Terminal {

    private long terminalId;
    private String terminalName;
    private String generatedHash;

}