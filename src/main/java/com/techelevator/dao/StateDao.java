package com.techelevator.dao;
import java.util.List;
import java.util.ArrayList;

import com.techelevator.model.State;

public interface StateDao {

    // CRUD Operations -----------------------------------------------------------------------------

    State createState(State state);

    State updateState(State state);

    boolean deleteState(String stateCode);




    // Search Return Methods -----------------------------------------------------------------------


    List<State> getStates();
    State getStatesByCode(String stateCode);


    // Possible Add Get States by Region --

}
