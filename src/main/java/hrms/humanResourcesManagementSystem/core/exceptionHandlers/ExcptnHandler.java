package hrms.humanResourcesManagementSystem.core.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import hrms.humanResourcesManagementSystem.core.utilities.ErrorResult;

@ControllerAdvice
public class ExcptnHandler {

	@ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleJsonExceptions(HttpMessageNotReadableException ex) {
        if(ex.getMessage().contains("birthDate")){
            return new ResponseEntity<>(
                    new ErrorResult("Wrong birth date format. Pattern should be like 2015-05-20 (YYYY-mm-dd)"),
                    HttpStatus.NOT_ACCEPTABLE
            );
        }
        return new ResponseEntity<>(new ErrorResult(ex.getMessage()),
                HttpStatus.NOT_ACCEPTABLE);
    }
}
