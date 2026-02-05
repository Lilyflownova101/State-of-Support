package com.techelevator.controller;

import java.security.Principal;
import java.util.List;
import com.techelevator.dao.CharityDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Charity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/charity")
@PreAuthorize("isAuthenticated()")
@CrossOrigin(origins = "http://localhost:5173")
public class CharityController {


    // Instance Variables ---------------------------------

    private CharityDao charityDao;

    // Constructor ----------------------------------------

    public CharityController(CharityDao charityDao) {
        this.charityDao = charityDao;
    }

    // Methods --------------------------------------------

    @PreAuthorize("permitAll()")
    @GetMapping("")
    public List<Charity> listAllCharities() {
        return charityDao.getCharities();
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/state", method = RequestMethod.GET)
    public List<Charity> listCharitiesByState(@RequestParam String stateCode) {
        return charityDao.getCharityByState(stateCode);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/city")
    public List<Charity> listCharitiesByCity(@RequestParam String city) {
        return charityDao.getCharityByCity(city);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/stateAndCity", method = RequestMethod.GET)
    public List<Charity> listCharitiesByStateAndCity(@RequestParam String stateCode, @RequestParam String city) {
        return charityDao.getCharityByStateAndCity(stateCode, city);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/zip", method = RequestMethod.GET)
    public List<Charity> listCharitiesByZip(@RequestParam String zipcode) {
        return charityDao.getCharitybyZip(zipcode);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Charity get(@PathVariable int id) {
        Charity charity = charityDao.getCharityById(id);
        if (charity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Charity matching that ID not found");
        } else {
            return charity;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Charity add(@Valid @RequestBody Charity charity, Principal principal) {
        System.out.println(principal.getName());
        return charityDao.createCharity(charity);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Charity update(@Valid @RequestBody Charity charity, @PathVariable int id) {
        charity.setCharityId(id);
        try {
            Charity updatedCharity = charityDao.updateCharity(charity);
            return updatedCharity;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Charity with matching ID not found");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        charityDao.deleteCharity(id);
    }
}
