package ru.agronomych.bell_project.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.agronomych.bell_project.user.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em){
        this.em = em;
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public List<User> all
}
