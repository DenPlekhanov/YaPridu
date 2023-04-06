package ru.yapridu.aptbooking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yapridu.aptbooking.model.entity.User;
import ru.yapridu.aptbooking.model.exception.UserNotFoundException;
import ru.yapridu.aptbooking.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
//    @PersistenceContext
//    private EntityManager em; //TODO Разобраться
    @Autowired
    private final UserRepository repository;

    public User createNew(User user) {
        return repository.save(user);
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User findById(Long userId) {
        Optional<User> userFromDb = repository.findById(userId);
        if (userFromDb.isPresent()) {
            return userFromDb.get();
        } else throw new UserNotFoundException("User with id "+ userId +" was not found.");
    }

    public User update(User user) {
        return repository.save(user);
    }

    public void deleteById(Long userId) {
        if (repository.findById(userId).isPresent()) {
            repository.deleteById(userId);
        }
        else throw new UserNotFoundException("User with id "+ userId +" was not found.");
    }
}
