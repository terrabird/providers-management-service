package com.terrabird.dao;

import com.terrabird.persistence.ProviderServiceMapping;
import com.terrabird.persistence.ServiceProvider;
import com.terrabird.persistence.ServiceType;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Praveer Das
 */
@Repository
public class ServiceProviderDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Cacheable
    public List<ServiceProvider> getAllServiceProviders() {
        Query query = entityManager.createQuery("select sp from ServiceProvider sp");
        return (List<ServiceProvider>) query.getResultList();
    }

    public ServiceProvider getServiceProviderById(String providerId) {
        return entityManager.find(ServiceProvider.class, providerId);
    }

    @Cacheable
    public List<ServiceType> getAllServiceTypesByProviderId(String providerId) {
        /*List<ProviderServiceMapping> providerMapping = entityManager.createQuery(
            "select psm " +
            "from ProviderServiceMapping psm " +
            "where psm.serviceProvider.serviceProviderId = :providerId", ProviderServiceMapping.class)
            .setParameter( "providerId", providerId )
            .getResultList();*/
        List<ServiceType> serviceTypes = new ArrayList<>();
        ServiceProvider sp = entityManager.find(ServiceProvider.class, providerId);
        for(ProviderServiceMapping mapping : sp.getServiceTypes()) {
            serviceTypes.add(mapping.getServiceType());
        }
        return serviceTypes;
    }
}
