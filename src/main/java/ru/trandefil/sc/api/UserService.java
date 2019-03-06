package ru.trandefil.sc.api;

import ru.trandefil.sc.model.User;

public interface UserService {

    User getLoggedUser(String userName, String password);

    User save(User user);

}
