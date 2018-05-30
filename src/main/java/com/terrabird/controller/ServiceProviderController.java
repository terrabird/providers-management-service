package com.terrabird.controller;

import com.terrabird.persistence.ServiceProvider;
import com.terrabird.persistence.ServiceType;
import com.terrabird.service.ServiceProviderBPO;
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

/**
 * @author Praveer Das
 */
@SuppressWarnings("unused")
@RestController
@EnableAutoConfiguration
public class ServiceProviderController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @SuppressWarnings("unused")
    @Autowired
    private ServiceProviderBPO serviceProviderBPO;

    @RequestMapping(value = "/serviceProviders", method = RequestMethod.GET)
    public List<ServiceProvider> getAllServiceProviders(ModelMap modelMap) {
        List<ServiceProvider> providerList = serviceProviderBPO.getAllServiceProviders();
        modelMap.put("ProviderList", providerList);
        return providerList;
    }

    @RequestMapping(value = "/serviceProviders/{providerId}", method = RequestMethod.GET)
    public ServiceProvider getServiceProviderById(@PathVariable String providerId) {
        return serviceProviderBPO.getServiceProviderById(providerId);
    }

    @RequestMapping(value = "/serviceTypes/{providerId}", method = RequestMethod.GET)
    public List<ServiceType> getAllServicesByProviderId(@PathVariable String providerId) {
        List<ServiceType> serviceTypeList = serviceProviderBPO.getAllServiceTypesByProviderId(providerId);
        for(ServiceType st : serviceTypeList) {
            log.debug(st.getServiceName());
        }
        return serviceTypeList;
    }
}
