package ru.trandefil.sc.repository;

import ru.trandefil.sc.api.UserRepository;
import ru.trandefil.sc.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {

    public static UserRepository userRepository = new UserRepositoryImpl();

    private static Map<String, User> users = new HashMap<>();

    static {
        init();
    }

    private UserRepositoryImpl() {
    }

    public static void init(){
        User user = new User(UUID.randomUUID().toString(),"User","user");
        User admin = new User(UUID.randomUUID().toString(),"Admin","admin");
        users.put(user.getUserName(),user);
        users.put(admin.getUserName(),admin);
    }

    @Override
    public User getLoggedUser(String userName, String password) {
        final User user = users.get(userName);
        if(user == null){
            System.out.println("bad user name.");
            return null;
        }
        if(!user.getPassword().equals(password)){
            System.out.println("bas password.");
            return null;
        }
        return user;
    }

    @Override
    public User save(User user) {
        return users.put(user.getUserName(),user);
    }

    public static UserRepository getInstance(){
        return userRepository;
    }

}
