package com.example.demo6;

import com.example.demo6.dao.UserRepository;
import com.example.demo6.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class Demo6Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Demo6Application.class, args);
		UserRepository userRepository=context.getBean(UserRepository.class);


		//CREATE
		User user=new User();
		user.setName("shrey");
		user.setCity("jabalpur");
		user.setStatus("java developer");

		User user1=userRepository.save(user);
		System.out.println(user1);

        //this save method saves only one object, if you want to save a List of students then you can use saveAll() method

		//READ
		Optional<User> optional=userRepository.findById(2);
		User user2=optional.get();
		System.out.println(user2);

		//UPDATE
		user2.setName("shrey saxena updated");
		userRepository.save(user2);
		System.out.println(user2);

		//DELETE
		userRepository.delete(user2);

		//we can also use deleteById()


	}

}
