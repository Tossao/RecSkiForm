package pl.coderslab.recskiform.service;

import pl.coderslab.recskiform.entity.User;

public interface UserService {

    User findByLogin (String name);
    void saveUser(User user);
}
