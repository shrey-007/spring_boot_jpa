package com.example.demo6.dao;

import com.example.demo6.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
   //CREATING CUSTOM QUERY METHODS
   public List<User> findByCity(String city);

   public List<User> findByNameAndCity(String name,String city);

   public List<User> findByNameStartingWith(String prefix);

   public List<User> findByNameEndingWith(String suffix);


   public List<User> findByNameContaining(String words);

   public List<User> findByNameLike(String likePattern);

   public List<User> findByAgeLessThan(int age);

   public List<User> findByAgeLessThanEqual(int age);

   public List<User> findByNameOrderById(String name);


}
