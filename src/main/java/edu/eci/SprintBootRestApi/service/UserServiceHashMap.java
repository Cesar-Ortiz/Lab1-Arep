package edu.eci.SprintBootRestApi.service;

import edu.eci.SprintBootRestApi.data.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceHashMap implements UserService {

    private final HashMap<String, User> usersHashMap= new HashMap<>();
    @Override
    public User create(User user) {
        usersHashMap.put(user.getId(), user);
        return user;
    }

    @Override
    public User findById(String id) {
        if(usersHashMap.containsKey(id)){
            return usersHashMap.get(id);
        }
        return null;
    }

    @Override
    public List<User> all() {
        List<User> users = new LinkedList<User>();
        for (User user : usersHashMap.values()) {
            users.add(user);
        }
        return users;
    }

    @Override
    public void deleteById(String id) {
        usersHashMap.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        usersHashMap.put(userId,user);
        return user;
    }
}
