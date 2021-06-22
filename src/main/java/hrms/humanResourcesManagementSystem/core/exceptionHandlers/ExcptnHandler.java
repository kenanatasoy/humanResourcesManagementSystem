package hrms.humanResourcesManagementSystem.core.exceptionHandlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorDataResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;

@ControllerAdvice
public class ExcptnHandler {

	// Ctrl + Shift + O
	// Ctrl + Shift + -
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDataResult<Object>> handleValidationExceptions(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<>();

        exceptions.getBindingResult().getFieldErrors()
                .forEach(fieldError -> {
                	validationErrors
                    .put(fieldError.getField(), fieldError.getDefaultMessage());
                	validationErrors
                	.put(fieldError.getField() + " rejectedValue", fieldError.getRejectedValue().toString());
                }
//                		System.out.println(fieldError.getRejectedValue())
//					        validationErrors
//                        .put(fieldError.getField(), fieldError.getDefaultMessage())
        );

        return ResponseEntity.badRequest().body(new ErrorDataResult<>(validationErrors, "Validation Errors"));
    }
	
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
	
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
//		Map<String,String> validationErrors = new HashMap<String, String>();
//		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
//			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
//		}
//
//		ErrorDataResult<Object> errors 
//		= new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
//		return errors;
//		
//	}
}
