package com.example.MongoDBProject.config;

import com.example.MongoDBProject.models.User;
import com.example.MongoDBProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "maria b", "maria@gmail.com");
        User alex = new User(null, "alex w", "alex@gmail.com");
        User bob = new User(null, "bob g", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
