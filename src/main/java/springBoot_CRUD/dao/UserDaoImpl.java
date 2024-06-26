package springBoot_CRUD.dao;

import springBoot_CRUD.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUser() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(getUserById(id));
    }

//    @Override
//    public void deleteUser(Long id) {
//        entityManager.createQuery("delete from User where id=:id").setParameter("id", id).executeUpdate();
//    }

    @Override
    public User getUserById(Long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException ("User not found");
        }
        return user;
    }

//    @Override
//    public User getUserById(int id) {
//        return entityManager.find(User.class, id);
//    }

}
