package springBoot_CRUD.dao;

import springBoot_CRUD.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> listUser();

    void editUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);


}
