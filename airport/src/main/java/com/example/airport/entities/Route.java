package com.example.airport.entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Route extends AbstractEntity{
    @Column(name = "PLANE_ID")
    private Long planeId;
    @Transient
    private Set<RoutePoint> routePoints = new HashSet<>();
    @Transient
    private RoutePoint startPoint;
    @Transient
    private RoutePoint finishPoint;

    public Route() {
        // for JPA
    }

    public Route(Long planeId) {
        this.planeId = planeId;
    }

    public Route(Long planeId, Collection<RoutePoint> routePoints) {
        this.routePoints.addAll(routePoints);
        this.planeId = planeId;
    }

    public Route(Long id, Long planeId) {
        this(planeId);
        this.setId(id);
    }

    public Long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Long boatId) {
        this.planeId = boatId;
    }

    public Set<RoutePoint> getRoutePoints() {
        return new HashSet<>(routePoints);
    }

    public void setRoutePoints(Collection<RoutePoint> routePoints) {
        this.routePoints.addAll(routePoints);
    }

    public RoutePoint getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(RoutePoint startPoint) {
        this.startPoint = startPoint;
    }

    public RoutePoint getFinishPoint() {
        return finishPoint;
    }

    public void setFinishPoint(RoutePoint finishPoint) {
        this.finishPoint = finishPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Route route = (Route) o;
        return Objects.equals(planeId, route.planeId) &&
                Objects.equals(routePoints, route.routePoints) &&
                Objects.equals(startPoint, route.startPoint) &&
                Objects.equals(finishPoint, route.finishPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), planeId, routePoints, startPoint, finishPoint);
    }
}
