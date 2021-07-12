package com.expense.tracker.controllers;

import com.expense.tracker.models.User;
import com.expense.tracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Class UserController
 */
@RestController
public class UserController {

  private UserService userService;


  public UserController(UserService userService)
  {
    this.userService = userService;
  }

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



  /**
   * //Opens Endpoint at /newUser to create new User
   * //End point takes new user object through request body
   * @param newUser //Todo, add Mapping and add PathVariable
   *
   */
  @PutMapping("/newUser")
  public void createNewUser(@RequestBody User newUser)
  {
    userService.createUser(newUser);
  }


  /**
   * //Todo add mapping and request body at endpoint /user/{uid}/
   * //Function will modify Existing User, New user object will be passed through the
   * request body.
   * @param        modifiedUser
   */
  @PutMapping("/user/limits/{uid")
  public void modifyUser(User modifiedUser)
  {
    userService.modifyUser(modifiedUser);
  }


  /**
   * //Todo implement Mapping, at /user/limits/{uid}
   * //Function will return the spending limits for the user.
   * @return       Map<String, Double>
   * @param        uid
   */
  @GetMapping("/user/limits/{uid}")
  public Map<String, Double> getUserLimits(@PathVariable  String uid)
  {
    return userService.getLimits(uid);
  }


  /**
   * //Todo implement mapping /user/spenditure/{uid}
   * //Function returns the Current Spenditures per category for the passed UID
   * @return       Map<String, Double>
   * @param        uid
   */

  @GetMapping("/user/spenditure/{uid}")
  public Map<String, Double>  getUserSpenditure(@PathVariable  String uid)
  {
     return userService.getCurrentSpending(uid);
  }


}
