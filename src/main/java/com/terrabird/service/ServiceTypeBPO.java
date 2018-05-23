package com.terrabird.service;

import com.terrabird.dao.ServiceTypeDAO;
import com.terrabird.entity.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Praveer Das
 */
@Component
public class ServiceTypeBPO {

    @Autowired
    private ServiceTypeDAO serviceTypeDAO;

    public List<ServiceType> getAllServiceTypes() {
        return serviceTypeDAO.findAll();
    }

    public ServiceType findServiceTypeById(String serviceTypeId) {
        return serviceTypeDAO.findServiceTypeById(serviceTypeId);
    }
}
