package com.terrabird.dao;

import com.terrabird.entity.ServiceType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Praveer Das
 */

@Component
@Repository
public class ServiceTypeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ServiceType> findAll() {
        /*Query query = entityManager.createNamedQuery(
            "query_find_all_service_types", ServiceType.class);*/
        Query query = entityManager.createQuery("select st from ServiceType st");
        return (List<ServiceType>) query.getResultList();
        //return query.getResultList();
    }

    public ServiceType findServiceTypeById(String serviceTypeId) {
        return entityManager.find(ServiceType.class, serviceTypeId);
    }
}
