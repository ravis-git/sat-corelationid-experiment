package com.example.predixcrudservice.model;


import lombok.Builder;
import lombok.Getter;

/**
 * Created by ravipalakodeti on 7/28/17.
 */
@Getter
@Builder
public class Terminal {

    private long terminalId;
    private String terminalName;

}
