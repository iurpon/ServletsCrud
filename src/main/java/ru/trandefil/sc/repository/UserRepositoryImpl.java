package ru.trandefil.sc.repository;

import ru.trandefil.sc.api.UserRepository;
import ru.trandefil.sc.model.User;

import java.util.*;

import static ru.trandefil.sc.util.EntityData.ROOT;
import static ru.trandefil.sc.util.EntityData.USER;

public class UserRepositoryImpl implements UserRepository {

    public static UserRepository userRepository = new UserRepositoryImpl();

    private static Map<String, User> users = new HashMap<>();

    static {
        init();
    }

    private UserRepositoryImpl() {
    }

    public static void init() {
        users.put(USER.getId(), USER);
        users.put(ROOT.getId(), ROOT);
    }

    @Override
    public User getLoggedUser(String userName, String password) {
        User user = users.values().stream()
                .filter(u -> u.getUserName().equals(userName) && u.getPassword().equals(password))
                .findAny().orElse(null);
        if (user == null) {
            System.out.println("bad user name or password.");
            return null;
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User save(User user) {
        if(user.isNew()){
            user.setId(UUID.randomUUID().toString());
        }
        return users.put(user.getUserName(), user);
    }

    public static UserRepository getInstance() {
        return userRepository;
    }

    @Override
    public void deleteById(String id) {
        users.remove(id);
    }

    @Override
    public User getById(String id) {
        return users.get(id);
    }

}
