package com.terrabird.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Date;

/**
 * @author Praveer Das
 */
@MappedSuperclass
public class HistoryData {

    @Column(name="CREATED_DATE", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdDate;
    @Column(name="LAST_UPDATED_DATE", nullable = false)
    @LastModifiedDate
    private Date lastUpdatedDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
