package com.terrabird.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Praveer Das
 */

@Entity
@Table(name = "TB_SERVICE_SUB_TYPE")
public class ServiceSubType extends HistoryData implements Serializable {

    private static final long serialVersionUID = 5415753829852525666L;

    @Id
    @Column(name = "SERVICE_SUB_TYPE_ID")
    protected String serviceSubTypeId;

    @Column(name = "SERVICE_TYPE_ID", nullable = false)
    private String serviceTypeId;

    @Column(name = "SERVICE_SUB_TYPE_NAME", nullable = false)
    private String serviceSubTypeName;

    @Column(name = "DESCRIPTION")
    private String description;

    public ServiceSubType() {}

    /* Getters and Setters */
    public String getServiceSubTypeId() {
        return serviceSubTypeId;
    }

    public void setServiceSubTypeId(String serviceSubTypeId) {
        this.serviceSubTypeId = serviceSubTypeId;
    }

    public String getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(String serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceSubTypeName() {
        return serviceSubTypeName;
    }

    public void setServiceSubTypeName(String serviceSubTypeName) {
        this.serviceSubTypeName = serviceSubTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
