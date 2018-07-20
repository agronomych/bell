package ru.agronomych.bellProject.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.agronomych.bellProject.organization.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OrganizationDaoImpl implements OrganizationDao{

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em){
        this.em = em;
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public List<Organization> all(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cQuery = builder.createQuery();
        cQuery.from(Organization.class);
        Query query = em.createQuery(cQuery);
        return query.getResultList();
    }

    @Override
    public Organization loadById(int id){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cQuery = builder.createQuery();
        Root organizations = cQuery.from(Organization.class);
        cQuery.where(builder.equal(organizations.get("id"), id));
        return em.find(Organization.class, id);
    }

    @Override
    public void save(Organization organization){
        em.persist(organization);
    }

    @Override
    public void update(Organization organization){
        /*CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<Organization> cUpdate = ;
        Root organizations = cUpdate.from(Organization.class);


        CriteriaQuery<Organization> organizationCriteria = builder.createQuery(Organization.class);*/
    }
}
