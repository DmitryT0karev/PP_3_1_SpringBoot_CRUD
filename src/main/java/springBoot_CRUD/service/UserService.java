package springBoot_CRUD.service;

import springBoot_CRUD.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> listUser();

    void editUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

}
