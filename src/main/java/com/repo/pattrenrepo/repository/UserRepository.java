package com.repo.pattrenrepo.repository;

import com.repo.pattrenrepo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository implements UsersRepository<User>{

    private Map<Integer, User> repository;

    public UserRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void user(User user) {
        repository.put(user.getId(), user);
    }

    @Override
    public User retrieve(int id) {
        return repository.get(id);
    }

    @Override
    public User search(String name) {
        Collection<User> users = repository.values();
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(name))
                return user;
        }
        return null;
    }

    @Override
    public User delete(int id) {
        User u = repository.get(id);
        this.repository.remove(id);
        return u;
    }
}
