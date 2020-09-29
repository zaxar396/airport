package com.example.airport.repo;

import com.example.airport.entities.Plane;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PlaneRepository extends CrudRepository<Plane, Long> {
    Iterable<Plane> findPlanesByDescriptionContaining(String description);
}
