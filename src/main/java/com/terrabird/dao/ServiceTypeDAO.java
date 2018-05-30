package com.terrabird.dao;

import com.terrabird.persistence.ServiceSubType;
import com.terrabird.persistence.ServiceType;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

/**
 * @author Praveer Das
 */

@Component
@Repository
public class ServiceTypeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ServiceType> findAll() {
        Query query = entityManager.createQuery("select st from ServiceType st");
        return (List<ServiceType>) query.getResultList();
    }

    @Cacheable
    public ServiceType findServiceTypeById(String serviceTypeId) {
        return entityManager.find(ServiceType.class, serviceTypeId);
    }

    @Cacheable
    public Set<ServiceSubType> findServiceSubTypesByServiceTypeId(String serviceTypeId) {
        ServiceType serviceType = entityManager.find(ServiceType.class, serviceTypeId);
        return serviceType.getServiceSubTypeSet();
    }
}
