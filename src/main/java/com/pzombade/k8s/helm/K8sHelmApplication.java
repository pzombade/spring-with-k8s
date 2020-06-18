package com.pzombade.k8s.helm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class K8sHelmApplication implements CommandLineRunner {

	static ConfigurableApplicationContext context = null;
	public static void main(String[] args) {
		context = SpringApplication.run(K8sHelmApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class,"userRepository");

		User u1= new User("P","Z","p@z.com");
		userRepository.save(u1);
		System.out.println("Saving u1 "+u1);

		User u2= new User("A","D","a@d.com");
		userRepository.save(u2);
		System.out.println("Saving u2 "+u2);
	}

	@Override
	public void run(String...args) throws Exception {
//
	}
}
