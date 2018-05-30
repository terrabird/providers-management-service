package com.terrabird.service;

import com.terrabird.dao.ServiceTypeDAO;
import com.terrabird.persistence.ServiceSubType;
import com.terrabird.persistence.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author Praveer Das
 */
@Service
public class ServiceTypeBPO {

    @SuppressWarnings("unused")
    @Autowired
    private ServiceTypeDAO serviceTypeDAO;

    public List<ServiceType> getAllServiceTypes() {
        return serviceTypeDAO.findAll();
    }

    public ServiceType findServiceTypeById(String serviceTypeId) {
        return serviceTypeDAO.findServiceTypeById(serviceTypeId);
    }

    public Set<ServiceSubType> findServiceSubTypesByServiceTypeId(String serviceTypeId) {
        return serviceTypeDAO.findServiceSubTypesByServiceTypeId(serviceTypeId);
    }
}
