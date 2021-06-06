package com.evolent.contactmanager.exception;

import com.evolent.types.ErrorReport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorReport> handleException(RuntimeException ex, WebRequest webRequest){

        HttpServletRequest request = ((ServletWebRequest) webRequest).getRequest();
        ErrorReport errorReport = new ErrorReport();

        if(ex instanceof  BusinessException){

            errorReport.setErrorCode(((BusinessException) ex).getErrorCode());
            errorReport.setErrorMessage(((BusinessException) ex).getErrorMessage());
        }else {
            errorReport.setErrorCode("500");
            errorReport.setErrorMessage(ex.getMessage());
        }

        return new ResponseEntity<>(errorReport, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
