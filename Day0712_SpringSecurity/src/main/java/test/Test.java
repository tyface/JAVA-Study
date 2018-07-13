package test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {
	public static void main(String[] args) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		
		System.out.println(encoder.encode("54"));
		
		boolean rs = encoder.matches("123", "$2a$10$OQFkitt4yy6iOtQK3jCUKeXcN7hxnOdVNY4fT2.XcEaMyV4r2223y");
		System.out.println(rs);
	}
}
