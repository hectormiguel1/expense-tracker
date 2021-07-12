package com.expense.tracker.services;

import com.expense.tracker.models.User;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Class UserService
 */
@Service
public class UserService {

  //
  // Fields
  //

  
  //
  // Constructors
  //
  public UserService () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  //
  // Other methods
  //

  /**
   * //Creates a new User, throws UserNotCreatedException is user was not created.
   * @param        newUser creates the new user in the DB
   */
  public void createUser(User newUser)
  {
  }


  /**
   * //Modifies the passed user, throws UserNotFoundException if the user could not
   * be found.
   * @param        userToModify User to be modified
   * 
   */
  public void modifyUser(User userToModify)
  {
  }


  /**
   * //Returns the Limits for the UID.
   * @return       Map<String, Double>
   * @param        userUID
   */
  public Map<String, Double> getLimits(String userUID)
  {
  }


  /**
   * //Returns the Current Spenditure per category for the passed UID
   * @return       Map<String, Double>
   * @param        userUID
   */
  public Map<String, Double>  getCurrentSpending(String userUID)
  {
  }


}
