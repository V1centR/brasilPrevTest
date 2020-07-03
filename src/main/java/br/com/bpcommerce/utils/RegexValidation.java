package br.com.bpcommerce.utils;

import java.util.regex.Pattern;

import org.json.JSONObject;

public class RegexValidation {

	String pattern;

	public boolean strValid(JSONObject data) {

		try {

			String email = data.getString("email");
			String firstName = data.getString("firstname");

			if (email.isEmpty() || firstName.isEmpty()) {

				return false;
			} else {

				boolean emailRegx = defValidation(email, "email");
				boolean firstNameRegx = defValidation(firstName, "name");

				if (firstNameRegx && emailRegx) {
					return true;

				} else {

					return false;
				}
			}

		} catch (Exception e) {
			return false;
		} // close tryCatch

	}

	public boolean categoryNameFilter(JSONObject data) {
		return defValidation(data.getString("name"), "categoryName");
	}
	
	public boolean productNameFilter(JSONObject data) {
		return defValidation(data.getString("name"), "product");
	}

	private boolean defValidation(String str, String type) {

		if (str.isEmpty()) {
			return false;
		} else {

			switch (type) {
			case "email":
				pattern = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
				break;
			case "name":
				pattern = "^[a-zA-Z ]{1,15}$";
				break;
			case "categoryName":
				pattern = "^[a-zA-Z ]{1,25}$";
				break;
			case "product":
				pattern = "^[a-zA-Z0-9 ]{1,99}$";
				break;
			case "phone":
				pattern = "^[0-9 ]{1,15}$";
				break;
			}

			Pattern regexPattern = Pattern.compile(pattern);

			return regexPattern.matcher(str).matches();
		}

	}

}
