package ru.agronomych.bellProject.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.agronomych.bellProject.user.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
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
    public List<User> all(){
        TypedQuery<User> query = em.createQuery("SELECT h FROM User h", User.class);
        return query.getResultList();
    }

    @Override
    public User loadById(int id){
        return em.find(User.class, id);
    }

    @Override
    public void save(User user){
        em.persist(user);
    }

    @Override
    public void update(User user){

    }
}
