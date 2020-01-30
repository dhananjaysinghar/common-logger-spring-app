package com.test.logger;

import org.springframework.http.HttpStatus;

import com.common.logger.rules.Priority;
import com.common.logger.rules.StandardErrors;

public enum InternalStandardError implements StandardErrors {
    
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "E5610", "Technical Error Occured",
            Priority.CRITICAL),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "E3681", "Please check the input param", Priority.NORMAL);

    private InternalStandardError(int statusCode, String logCode, String message, Priority priority) {
        this.statusCode = String.valueOf(statusCode);
        this.logCode = logCode;
        this.message = message;
        this.priority = priority;

    }

    private String statusCode;
    private String logCode;
    private String message;
    private Priority priority;

    public String getStatusCode() {
        return statusCode;
    }

    public String getLogCode() {
        return logCode;
    }

    public String getMessage() {
        return message;
    }

    public Priority getPriority() {
        return priority;
    }

}
