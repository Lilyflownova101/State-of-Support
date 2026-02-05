package com.techelevator.controller;

import com.techelevator.dao.StateDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.State;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/state")
@PreAuthorize("isAuthenticated()")
@CrossOrigin(origins = "http://localhost:5173")
public class StateController {



    // Instance Variables ---------------------------------

    private StateDao stateDao;

    // Constructor ----------------------------------------

    public StateController(StateDao stateDao) {
        this.stateDao = stateDao;
    }

    // Methods --------------------------------------------

    @PreAuthorize("permitAll()")
    @GetMapping("")
    public List<State> listAllStates() {
        return stateDao.getStates();
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/{stateCode}", method = RequestMethod.GET)
    public State get(@PathVariable String stateCode) {
        State state = stateDao.getStatesByCode(stateCode);
        if (state == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "State matching that code not found");
        } else {
            return state;
        }
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public State add(@Valid @RequestBody State state, Principal principal) {
        System.out.println(principal.getName());
        return stateDao.createState(state);
    }

    @RequestMapping(path = "/{stateCode}", method = RequestMethod.PUT)
    public State update(@Valid @RequestBody State state, @PathVariable String stateCode) {
        state.setStateCode(stateCode);
        try {
            State updatedState = stateDao.updateState(state);
            return updatedState;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "State with matching code not found");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{stateCode}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String stateCode) {
        stateDao.deleteState(stateCode);
    }

}
