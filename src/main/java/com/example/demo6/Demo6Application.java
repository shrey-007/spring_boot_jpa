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
		//UserRespository interface has all methods to interact with database, we dont need to explicitly define methods in userRepository,
        // we just need to extendit
		User user=new User();
		user.setName("shrey");
		user.setCity("jabalpur");
		user.setStatus("java developer");

		User user1=userRepository.save(user);
		System.out.println(user1);

        //this save method saves only one object, if you want to save a List of students then you can use saveAll() method

		//READ
		//we got row by giving its id(@Id attribute in User class).And that whole row's columns have been converted to an User object with respective attributes
		Optional<User> optional=userRepository.findById(2);
		User user2=optional.get();
		System.out.println(user2);
		//this user2 has id 2 and other attributes

		//UPDATE
		//because user2 was having id 2, so  row which has id=2 has been updated
		user2.setName("shrey saxena updated");
		userRepository.save(user2);
		System.out.println(user2);

		//DELETE
       //because user2 was having id 2, so  row which has id=2 has been deleted
		userRepository.delete(user2);

		//we can also use deleteById()


	}

}
