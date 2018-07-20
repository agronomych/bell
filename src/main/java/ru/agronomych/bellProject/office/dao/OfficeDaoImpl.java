package ru.agronomych.bellProject.office.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.agronomych.bellProject.office.model.Office;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OfficeDaoImpl implements OfficeDao {

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em){
        this.em = em;
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public List<Office> all(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cQuery = builder.createQuery();
        cQuery.from(Office.class);
        Query query = em.createQuery(cQuery);
        return query.getResultList();
    }

    @Override
    public Office loadById(int id){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cQuery = builder.createQuery();
        Root offices = cQuery.from(Office.class);
        cQuery.where(builder.equal(offices.get("id"), id));
        return em.find(Office.class, id);
    }

    @Override
    public void save(Office office){
        em.persist(office);
    }

    @Override
    public void update(Office office){
        /*CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<Office> cUpdate = ;
        Root offices = cUpdate.from(Office.class);


        CriteriaQuery<Office> officeCriteria = builder.createQuery(Office.class);*/
    }
}
