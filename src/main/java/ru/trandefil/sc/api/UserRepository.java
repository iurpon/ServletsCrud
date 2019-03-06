package ru.trandefil.sc.api;

import ru.trandefil.sc.model.User;

public interface UserRepository {

    User getLoggedUser(String userName, String password);

    User save(User user);

}
