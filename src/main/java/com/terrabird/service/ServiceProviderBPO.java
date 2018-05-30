package com.terrabird.service;

import com.terrabird.dao.ServiceProviderDAO;
import com.terrabird.persistence.ServiceProvider;
import com.terrabird.persistence.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Praveer Das
 */
@Service
public class ServiceProviderBPO {

    @Autowired
    private ServiceProviderDAO serviceProviderDAO;

    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderDAO.getAllServiceProviders();
    }

    public ServiceProvider getServiceProviderById(String providerId) {
        return serviceProviderDAO.getServiceProviderById(providerId);
    }

    public List<ServiceType> getAllServiceTypesByProviderId(String providerId) {
        return serviceProviderDAO.getAllServiceTypesByProviderId(providerId);
    }
}
