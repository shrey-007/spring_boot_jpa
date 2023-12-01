package com.example.demo6.dao;

import com.example.demo6.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
   //CREATING CUSTOM QUERY METHODS
   public List<User> findByCity(String city);

   public List<User> findByNameAndCity(String name,String city);

   public List<User> findByNameStartingWith(String prefix);

   public List<User> findByNameEndingWith(String suffix);


   public List<User> findByNameContaining(String words);

   public List<User> findByNameLike(String likePattern);

//   public List<User> findByAgeLessThan(int age);

//   public List<User> findByAgeLessThanEqual(int age);

   public List<User> findByNameOrderById(String name);


   //WRITING EXPLICIT QUERIES
   //nativeQuery=true se ye pata pdta hai springboot ko ki jis dbms ko use kr rhe h uski native query hai, means ye mysql ki native query sql hai
   //agar query mai parameters paas krne hai toh name=:n karo and @Param mai n ko name se bind krdo toh jo parameter name mai value aaegi vo
   //n ki jagah chali jaaegi.

   @Query(value = "select * from user",nativeQuery = true)
   public List<User> getAllUsers();

   @Query(value = "select * from user where name=:n and city=:c",nativeQuery = true)
   public List<User> func2(@Param("n")String name,@Param("c") String city);


}
