package com.expense.tracker.controllers;

import com.expense.tracker.models.User;
import com.expense.tracker.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Class UserController
 */
@RestController
public class UserController {

  @Autowired
  private UserService userService;


  public UserController(UserService userService)
  {
    this.userService = userService;
  }

  private final Logger log = LoggerFactory.getLogger(UserController.class);

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
  @CrossOrigin
  @PutMapping("/newUser")
  public void createNewUser(@RequestBody User newUser)
  {
    log.info("Adding new user: " + newUser);
    userService.createUser(newUser);
  }


  /**
   * //Todo add mapping and request body at endpoint /user/{uid}/
   * //Function will modify Existing User, New user object will be passed through the
   * request body.
   * @param        modifiedUser
   */
  @PutMapping("/user")
  @CrossOrigin
  public void modifyUser(@RequestBody User modifiedUser)
  {
    log.info("Modifying user: " + modifiedUser.getUid() + " with data: " + modifiedUser);
    userService.modifyUser(modifiedUser);
  }


  /**
   * //Todo implement Mapping, at /user/limits/{uid}
   * //Function will return the spending limits for the user.
   * @return       Map<String, Double>
   * @param        uid
   */
  @GetMapping("/user/{uid}/limits")
  @CrossOrigin
  public Map<String, Double> getUserLimits(@PathVariable  String uid)
  {
    log.info("Getting user Limits for user: " + uid);
    return userService.getLimits(uid);
  }


  /**
   * //Todo implement mapping /user/Expenditure/{uid}
   * //Function returns the Current Expenditures per category for the passed UID
   * @return       Map<String, Double>
   * @param        uid
   */

  @GetMapping("/user/{uid}/expenditure")
  @CrossOrigin
  public Map<String, Double> getUserExpenditure(@PathVariable  String uid)
  {
    log.info("Getting user Expenditure for user " + uid);
     return userService.getCurrentSpending(uid);
  }


}
