package com.example.MongoDBProject.services;

import com.example.MongoDBProject.exception.ObjectNotFoundException;
import com.example.MongoDBProject.models.User;
import com.example.MongoDBProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public void delete (String id) {
        findById(id);
        repository.deleteById(id);
    }

    public void updateData (User newObj, User obj) {
        newObj.setName((obj.getName()));
        newObj.setEmail(obj.getEmail());
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }
}
