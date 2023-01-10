package org.springframework.samples.petclinic.care;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingControllerAdvice {
	
    @ExceptionHandler({UnfeasibleCareException.class, NonCompatibleCaresException.class})
	public String handleInvalidCareException(HttpServletRequest request, Exception ex){		
		return "cares/InvalidCare";
	}
}
