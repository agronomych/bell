package ru.agronomych.bell_project.docs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.agronomych.bell_project.docs.model.Doc;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @InheritDoc
 */
public class DocDaoImpl implements DocDao {
    private final EntityManager em;

    @Autowired
    public DocDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Doc> all(){
        TypedQuery<Doc> query = em.createQuery("SELECT h FROM Country h", Doc.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Doc loadByCode(Integer code){
        return em.find(Doc.class, code);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Doc country){
        em.persist(country);
    }
}
