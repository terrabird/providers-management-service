package com.terrabird.controller;

import com.terrabird.entity.ServiceType;
import com.terrabird.service.ServiceTypeBPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Praveer Das
 */
@RestController
@EnableAutoConfiguration
public class ServiceManagementController {

    @Autowired
    private ServiceTypeBPO serviceTypeBPO;

    @RequestMapping(value = "/serviceCategories", method = RequestMethod.GET)
    public List<ServiceType> getAllServiceCategories(ModelMap modelMap) {
        List<ServiceType> serviceTypes = serviceTypeBPO.getAllServiceTypes();
        modelMap.put("ServiceTypes", serviceTypes);
        return serviceTypes;
    }

    @RequestMapping(value = "/serviceCategories/{serviceTypeId}")
    public ServiceType findServiceTypeById(@PathVariable String serviceTypeId){
        return serviceTypeBPO.findServiceTypeById(serviceTypeId);
    }
}
