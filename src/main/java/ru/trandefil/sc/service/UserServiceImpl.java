package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.UserRepository;
import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.model.User;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
@ManagedBean
public class UserServiceImpl implements UserService{

//    private static UserService userService;

    @Inject
    private UserRepository userRepository;

//    private UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public User getLoggedUser(@NonNull final String userName, @NonNull final String password) {
        return userRepository.getLoggedUser(userName,password);
    }

    @Override
    public User save(@NonNull final User user) {
        return userRepository.save(user);
    }

/*    public static UserService getInstance(@NonNull final UserRepository userRepository){
        if(userService == null){
            userService = new UserServiceImpl(userRepository);
        }
        return userService;
    }*/

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void deleteById(@NonNull final String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getById(@NonNull final String id) {
        return userRepository.getById(id);
    }

}
