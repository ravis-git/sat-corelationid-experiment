package com.example.predixaggregateservice.service;

import com.example.predixaggregateservice.model.Terminal;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ravipalakodeti on 7/31/17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TerminalAggregateImplTest {

    @Autowired
    TerminalAggregateServiceImpl terminalAggregateService;

    @Test
    @Ignore
    public void testTerminalService() {
        Terminal terminal = terminalAggregateService.getTerminalDetails();
         Assert.assertNotNull(terminal);
         Assert.assertEquals(terminal.getTerminalId(), 123);
     }
}