package com.terrabird.controller;

import com.terrabird.persistence.ServiceSubType;
import com.terrabird.persistence.ServiceType;
import com.terrabird.service.ServiceTypeBPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @author Praveer Das
 */
@SuppressWarnings("unused")
@RestController
@EnableAutoConfiguration
public class ServiceManagementController {

    @SuppressWarnings("unused")
    @Autowired
    private ServiceTypeBPO serviceTypeBPO;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/serviceCategories", method = RequestMethod.GET)
    public List<ServiceType> getAllServiceCategories(ModelMap modelMap) {
        List<ServiceType> serviceTypes = serviceTypeBPO.getAllServiceTypes();
        modelMap.put("ServiceTypes", serviceTypes);
        return serviceTypes;
    }

    @RequestMapping(value = "/serviceCategories/{serviceTypeId}")
    public ServiceType getServiceTypeById(@PathVariable String serviceTypeId){
        ServiceType st = serviceTypeBPO.findServiceTypeById(serviceTypeId);
        log.debug("Service Category :: " + st.getServiceName());
        return st;
    }

    @RequestMapping(value = "/serviceSubCategories/{serviceTypeId}")
    public Set<ServiceSubType> getServiceSubTypesByServiceType(@PathVariable String serviceTypeId) {
        Set<ServiceSubType> s = serviceTypeBPO.findServiceSubTypesByServiceTypeId(serviceTypeId);
        for(ServiceSubType sst : s) {
            log.debug(sst.getServiceSubTypeId() + " " + sst.getServiceSubTypeName());
        }
        return s;
    }
}
