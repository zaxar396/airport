package com.example.airport.controllers;

import com.example.airport.entities.Plane;
import com.example.airport.repo.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class PlaneController implements AbstractController<Plane> {
    private PlaneRepository planeRepository;

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory){ this.entityManagerFactory = entityManagerFactory;}

    @Autowired
    public void setPlaneRepository(PlaneRepository planeRepository){
        this.planeRepository = planeRepository;
    }

    @GetMapping("/")
    public String getMain(Model model){
        return "index";
    }

//    @GetMapping("/planes")
//    public String getAllPlanes(Model model){
//        Iterable<Plane> planes = planeRepository.findAll();
//        model.addAttribute("planes", planes);
//        return "planes";
//    }

    Set<Plane> iterableToSet(Iterable<Plane> iterable) {
        Set<Plane> result = new HashSet<>();
        iterable.forEach(result::add);
        return result;
    }

    @GetMapping("/planes")
    public ResponseEntity<Collection<Plane>> getAllPlanes(@RequestParam(value = "description", required = false) String description){
        HttpHeaders responseHeaders = new HttpHeaders();

        Set<Plane> planes = iterableToSet(planeRepository.findPlanesByDescriptionContaining(description));

        return new ResponseEntity<>(planes, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/planes_unsafe")
    public ResponseEntity<Collection<Plane>> getAllPlanes_unsafe(@RequestParam(value = "description", required = false) String description){
        HttpHeaders responseHeaders = new HttpHeaders();

        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createNativeQuery("select * from PLANE where DESCRIPTION = '" + description + "'");
        List<Plane> result = query.getResultList();

        return new ResponseEntity<>(result, responseHeaders, HttpStatus.OK);
    }

    

    @GetMapping("/planes/add")
    public String addPlane(Model model){
        return "plane-add";
    }
    @PostMapping("/planes/add")
    public String addPostPlane(Model model, @RequestParam String description, @RequestParam Integer maxSpeed){
        Plane plane = new Plane(description, maxSpeed);
        planeRepository.save(plane);
        Iterable<Plane> planes = planeRepository.findAll();
        model.addAttribute("planes", planes);
         return "planes";
    }
}
