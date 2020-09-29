package com.example.airport.entities;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Plane extends AbstractEntity{
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MAX_SPEED")
    private Integer maxSpeed;

    public Plane(){
        super();
    }

    public Plane(String description, Integer maxSpeed){
        this.description = description;
        this.maxSpeed = maxSpeed;
    }

    public Plane(Long id, String description, Integer maxSpeed){
        this(description,maxSpeed);
        this.setId(id);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return Objects.equals(description, plane.description) &&
                Objects.equals(maxSpeed, plane.maxSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, maxSpeed);
    }
}
