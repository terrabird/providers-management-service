package com.terrabird.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Praveer Das
 */
@Entity
@NamedQuery(query = "select st from ServiceType st", name = "query_find_all_service_types")
@Table(name = "TB_SERVICE_TYPE")
public class ServiceType extends HistoryData implements Serializable {

    private static final long serialVersionUID = 5415753829852525666L;

    @Id
    @Column(name="SERVICE_TYPE_ID")
    protected String serviceTypeId;
    @Column(name="SERVICE_NAME")
    private String serviceName;
    @Column(name="DESCRIPTION")
    private String description;


    public ServiceType() {}

    @OneToMany
    @JoinColumn(name="SERVICE_TYPE_ID", referencedColumnName="SERVICE_TYPE_ID")
    private Set<ServiceSubType> serviceSubTypeSet = new HashSet();

    /* Getters and Setters */
    public String getServiceTypeId() {
        return serviceTypeId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceTypeName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ServiceSubType> getServiceSubTypeSet() {
        return serviceSubTypeSet;
    }

    public void setServiceSubTypeSet(Set<ServiceSubType> serviceSubTypeSet) {
        this.serviceSubTypeSet = serviceSubTypeSet;
    }

    @Override
    public String toString() {
        return serviceTypeId + "::" + serviceName + "::" + getCreatedDate() + "::" + getLastUpdatedDate() + "::" +
               getObjectVersionNumber();
    }
}
