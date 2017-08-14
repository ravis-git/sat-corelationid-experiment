package com.example.predixcrudservice.repository;

import com.example.predixcrudservice.model.Terminal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by ravipalakodeti on 7/31/17.
 */
@Component
@Slf4j
public class TerminalRepository {

    public Terminal getTerminalDetails() {
//        log.info("=>(5): {}", "inside crud service repository method");
        return Terminal.builder()
                .terminalId(123)
                .terminalName("Chicago")
                .build();
    }
}
