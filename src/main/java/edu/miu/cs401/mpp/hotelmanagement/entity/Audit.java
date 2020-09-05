package edu.miu.cs401.mpp.hotelmanagement.entity;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Audit {
    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public Audit setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public Audit setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }
}
