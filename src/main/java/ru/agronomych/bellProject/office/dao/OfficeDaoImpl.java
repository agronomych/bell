package ru.agronomych.bellProject.office.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.agronomych.bellProject.office.model.Office;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
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

    /**
     * {@InheritDoc}
     */
    @Override
    public Office loadById(int id){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cQuery = builder.createQuery();
        Root offices = cQuery.from(Office.class);
        cQuery.where(builder.equal(offices.get("id"), id));
        Query query = em.createQuery(cQuery);
        return (Office) query.getSingleResult();
        //return em.find(Office.class, id);
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public void save(Office office){
        em.persist(office);
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public void update(Office office){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<Office> cUpdate = builder.createCriteriaUpdate(Office.class);
        Root offices = cUpdate.from(Office.class);
        cUpdate.where(builder.equal(offices.get("id"),office.getId()));
        if (office.getActive()!=null) cUpdate.set("isActive",office.getActive());
        if (office.getPhone()!=null) cUpdate.set("phone",office.getPhone());
        if (office.getAddress()!=null) cUpdate.set("address",office.getAddress());
        if (office.getName()!=null) cUpdate.set("name",office.getName());
        if (office.getOrgId()!=null) cUpdate.set("orgId",office.getOrgId());

        Query query = em.createQuery(cUpdate);
        query.executeUpdate();
    }
}