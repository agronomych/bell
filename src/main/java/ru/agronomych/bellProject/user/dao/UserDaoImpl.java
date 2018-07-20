package ru.agronomych.bellProject.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.agronomych.bellProject.user.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
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
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cQuery = builder.createQuery();
        cQuery.from(User.class);
        Query query = em.createQuery(cQuery);
        return query.getResultList();
    }

    @Override
    public User loadById(int id){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cQuery = builder.createQuery();
        Root users = cQuery.from(User.class);
        cQuery.where(builder.equal(users.get("id"), id));
        return em.find(User.class, id);
    }

    @Override
    public void save(User user){
        em.persist(user);
    }

    @Override
    public void update(User user){
        /*CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<User> cUpdate = ;
        Root users = cUpdate.from(User.class);


        CriteriaQuery<User> userCriteria = builder.createQuery(User.class);*/
    }
}
