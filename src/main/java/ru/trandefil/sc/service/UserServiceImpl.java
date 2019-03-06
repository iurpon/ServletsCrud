package ru.trandefil.sc.service;

import ru.trandefil.sc.api.UserRepository;
import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.model.User;

public class UserServiceImpl implements UserService{

    private static UserService userService;

    private UserRepository userRepository;

    private UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getLoggedUser(String userName, String password) {
        return userRepository.getLoggedUser(userName,password);
    }

    @Override
    public User save(User user) {
        return null;
    }

    public static UserService getInstance(UserRepository userRepository){
        if(userService == null){
            userService = new UserServiceImpl(userRepository);
        }
        return userService;
    }

}
