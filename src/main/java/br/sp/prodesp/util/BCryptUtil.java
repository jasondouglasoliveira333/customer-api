package br.sp.prodesp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptUtil {
	public static void main(String... args) {
		try {
			System.out.println(new BCryptPasswordEncoder().encode("admin"));
		}catch (Exception  e) {
			e.printStackTrace();
		}
	}
}
