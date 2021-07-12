package com.expense.tracker.controllers;

/**
 * Class UserController
 */
public class UserController {

  //
  // Fields
  //

  private UserService userService;
  
  //
  // Constructors
  //
  public UserController () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of userService
   * @param newVar the new value of userService
   */
  public void setUserService (UserService newVar) {
    userService = newVar;
  }

  /**
   * Get the value of userService
   * @return the value of userService
   */
  public UserService getUserService () {
    return userService;
  }

  //
  // Other methods
  //

  /**
   * //Opens Endpoint at /newUser to create new User
   * //End point takes new user object through request body
   * @param        newUser //Todo, add Mapping and add PathVariable
   * 
   */
  public void createNewUser(User newUser)
  {
  }


  /**
   * //Todo add mapping and request body at endpoint /user/{uid}/
   * //Function will modify Existing User, New user object will be passed through the
   * request body.
   * @param        modifiedUser
   */
  public void modifyUser(User modifiedUser)
  {
  }


  /**
   * //Todo implement Mapping, at /user/limits/{uid}
   * //Function will return the spending limits for the user.
   * @return       Map<String, Double>
   * @param        userUID
   */
  public Map<String, Double>  getUserLimits(String userUID)
  {
  }


  /**
   * //Todo implement mapping /user/spenditure/{uid}
   * //Function returns the Current Spenditures per category for the passed UID
   * @return       Map<String, Double>
   * @param        userUID
   */
  public Map<String, Double>  getUserSpenditure(String userUID)
  {
  }


}
