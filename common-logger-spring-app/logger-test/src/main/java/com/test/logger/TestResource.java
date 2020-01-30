package com.test.logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.logger.utils.LoggingService;

@RestController
public class TestResource {

    private static LoggingService loggingService = LoggingService.getLogger(TestResource.class);
    
    @GetMapping("/get")
    public ResponseEntity<String> get(){
        loggingService.logUserJourney("Executing get() ");
        
        try {
            loggingService.successLog("I0009", "successfully executed get");
            System.out.println(10/0);
        }catch (Exception e) {
            loggingService.errorLog(InternalStandardError.INTERNAL_SERVER_ERROR, "Error occured in get method", e);
        }
        
        return ResponseEntity.ok("Hello Dhananjay");
    }
}
