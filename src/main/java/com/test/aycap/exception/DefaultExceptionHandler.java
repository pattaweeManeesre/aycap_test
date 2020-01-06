package com.test.aycap.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> othersErrorHandler(final Exception e) {
        LOG.error("got exception !!!", e);

        return response(new JSONResponse().fail().toString());
    }

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<String> baseExceptionHandler(final BaseException e) {
        LOG.error("got base exception !!!", e);

        try {
            return response(new JSONResponse().fail(e.getErrorCode()).toString());
        }
        catch (Exception ex)
        {
            LOG.error("got exception again !!!", ex);
            return response(new JSONResponse().fail().toString());
        }
    }

    private ResponseEntity<String> response(String message){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(message, headers, HttpStatus.OK);
    }

}