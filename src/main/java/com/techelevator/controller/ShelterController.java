package com.techelevator.controller;

import java.security.Principal;
import java.util.List;

import com.techelevator.dao.ShelterDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Shelter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



@RestController
@RequestMapping("/shelter")
@PreAuthorize("isAuthenticated()")
@CrossOrigin(origins = "http://localhost:5173")
public class ShelterController {

    // Instance Variables ---------------------------------

    private ShelterDao shelterDao;

    // Constructor ----------------------------------------

    public ShelterController(ShelterDao shelterDao) {
        this.shelterDao = shelterDao;
    }

    // Methods --------------------------------------------

    @PreAuthorize("permitAll()")
    @GetMapping("")
    public List<Shelter> listAllShelters() {
        return shelterDao.getShelters();
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/state")
    public List<Shelter> listSheltersByState(@RequestParam String stateCode) {
        return shelterDao.getSheltersByState(stateCode);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/city")
    public List<Shelter> listShelterByCity(@RequestParam String city){
        return shelterDao.getShelterByCity(city);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/stateAndCity")
    public List<Shelter> listSheltersByStateAndCity(@RequestParam String stateCode, @RequestParam String city) {
        return shelterDao.getShelterByStateAndCity(stateCode, city);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/name", method = RequestMethod.GET)
    public List<Shelter> listSheltersByName(@RequestParam String name) {
        return shelterDao.getShelterByName(name);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Shelter get(@PathVariable int id) {
        Shelter shelter = shelterDao.getShelterById(id);
        if (shelter == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Shelter matching that ID not found");
        } else {
            return shelter;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Shelter add(@Valid @RequestBody Shelter shelter, Principal principal) {
        System.out.println(principal.getName());
        return shelterDao.createShelter(shelter);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Shelter update(@Valid @RequestBody Shelter shelter, @PathVariable int id) {
        shelter.setShelterId(id);
        try {
            Shelter updatedShelter = shelterDao.updateShelter(shelter);
            return updatedShelter;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Shelter with matching ID not found");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        shelterDao.deleteShelter(id);
    }
}
