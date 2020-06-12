package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LoginApplication  implements  CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
		
		String s1= "java";
		StringBuilder s2= new StringBuilder("java");
		modificarString(s1);
		modificarStringBuilder(s2);
		System.out.println(s1+s2);
		
		String c1="java";
		if(c1==s1) {System.out.println("igual objeto");}
		if(c1.equals(s1)) {System.out.println("igual contenido");}
		
		
		
	}
private static void modificarStringBuilder(StringBuilder s3) {
		s3=s3.append("c");
		
	}
private static void modificarString(String s1) {
		s1=s1.replace("j", "l");
		
	}
@Override
public void run(String... args) throws Exception {
	BCryptPasswordEncoder e = new BCryptPasswordEncoder();
	System.out.println(e.encode("123456")); 
	System.out.println(e.encode("David1")); 
} 
}
