package com.resilience.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.resilience.spring.model.Customer;

@Component
public class CustomerValidator implements Validator {


	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer c=(Customer)target;
		String phn = Long.toString(c.getMobile_no());
		if(phn.length() != 10) {
			errors.rejectValue("Mobile_no", "invalidPhoneNumber", "Invalid PhoneNumber....Enter again!!");
		}	
		
	}
}


