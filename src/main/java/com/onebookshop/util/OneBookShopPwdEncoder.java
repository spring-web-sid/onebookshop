package com.onebookshop.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component("passwordEncoder")
public class OneBookShopPwdEncoder {

	public String encode(String password)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	
	
}
