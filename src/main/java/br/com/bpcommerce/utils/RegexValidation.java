package br.com.bpcommerce.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RegexValidation {
	
	public boolean strValid(JSONObject data) {
		
		
		String emailPattern = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
		String regex = "^[a-zA-Z ]{1,15}$";
		
		Pattern pattern = Pattern.compile(regex);
		Pattern emailRegex = Pattern.compile(emailPattern);
		
		
		try {
			
			String email = data.getString("email");
			String firstName = data.getString("firstname");
			
			
			Matcher firstNameMatcher = pattern.matcher(firstName);
			Matcher emailMatcher = emailRegex.matcher(email);
			
			if(email.isEmpty() || firstName.isEmpty()) {
				
				return false;
			} else {
				
				if(firstNameMatcher.matches() && emailMatcher.matches())
				{
					return true;

				} else {

					return false;
				}			
			}
			
			
		} catch (Exception e) {
			return false;
		}//close tryCatch
		
	}

}
