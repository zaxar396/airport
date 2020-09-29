package com.example.airport.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Airport extends AbstractEntity{
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CAPACITY")
    private Integer capacity;
    @Column(name = "LATITUDE")
    private Double latitude;
    @Column(name = "LONGITUDE")
    private Double longitude;

    public Airport() {
        // for JPA
    }

    public Airport(String description, Integer capacity, Double latitude, Double longitude) {
        this.description = description;
        this.capacity = capacity;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Airport(Long id, String description, Integer capacity, Double latitude, Double longitude) {
        this(description, capacity, latitude, longitude);
        this.setId(id);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Airport airport = (Airport) o;
        return Objects.equals(description, airport.description) &&
                Objects.equals(capacity, airport.capacity) &&
                Objects.equals(latitude, airport.latitude) &&
                Objects.equals(longitude, airport.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, capacity, latitude, longitude);
    }
}
