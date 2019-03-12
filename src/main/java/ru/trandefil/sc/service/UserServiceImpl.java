package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.UserRepository;
import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.model.User;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
@ManagedBean
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @PersistenceContext(unitName = "EM",type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    public User getLoggedUser(@NonNull final String userName, @NonNull final String password) {
        return userRepository.getLoggedUser(userName, password);
    }

    @Override
    public User save(@NonNull final User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        Query query = entityManager.createQuery("select u from User u");
        return (List<User>)query.getResultList();
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
