package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.UserRepository;
import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService{

    private static UserService userService;

    private UserRepository userRepository;

    private UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getLoggedUser(@NonNull final String userName, @NonNull final String password) {
        return userRepository.getLoggedUser(userName,password);
    }

    @Override
    public User save(@NonNull final User user) {
        return userRepository.save(user);
    }

    public static UserService getInstance(@NonNull final UserRepository userRepository){
        if(userService == null){
            userService = new UserServiceImpl(userRepository);
        }
        return userService;
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }
}
