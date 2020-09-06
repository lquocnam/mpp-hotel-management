package edu.miu.cs401.mpp.hotelmanagement.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    protected Long id;

    @Embedded
    protected Audit audit = new Audit();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @PrePersist
    public void prePersist() {
        audit.setCreatedOn(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate() {
        audit.setUpdatedOn(LocalDateTime.now());
    }
}
