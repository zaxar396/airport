package com.example.airport.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class RoutePoint extends AbstractEntity {
    @Column(name = "ROUTE_POINT_INDEX")
    private Integer routePointIndex;
    @Column(name = "DEPART_TIME")
    private Timestamp departTime;
    @Column(name = "ARRIVE_TIME")
    private Timestamp arriveTime;
    @Column(name = "ROUTE_ID")
    private Long routeId;
    @Column(name = "SHIPYARD_ID")
    private Long shipyardId;

    public RoutePoint() {
        // for JPA
    }

    public RoutePoint(Integer routePointIndex, Timestamp arriveTime, Timestamp departTime, Long routeId, Long shipyardId) {
        this.routePointIndex = routePointIndex;
        this.departTime = departTime;
        this.arriveTime = arriveTime;
        this.routeId = routeId;
        this.shipyardId = shipyardId;
    }

    public RoutePoint(Long id, Integer routePointIndex, Timestamp arriveTime, Timestamp departTime, Long routeId, Long shipyardId) {
        this(routePointIndex, arriveTime, departTime, routeId, shipyardId);
        this.setId(id);
    }

    public Integer getRoutePointIndex() {
        return routePointIndex;
    }

    public void setRoutePointIndex(Integer routePointIndex) {
        this.routePointIndex = routePointIndex;
    }

    public Timestamp getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Timestamp departTime) {
        this.departTime = departTime;
    }

    public Timestamp getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Timestamp arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Long getShipyardId() {
        return shipyardId;
    }

    public void setShipyardId(Long shipyardId) {
        this.shipyardId = shipyardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoutePoint that = (RoutePoint) o;
        return Objects.equals(routePointIndex, that.routePointIndex) &&
                Objects.equals(departTime, that.departTime) &&
                Objects.equals(arriveTime, that.arriveTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), routePointIndex, departTime, arriveTime);
    }
}
