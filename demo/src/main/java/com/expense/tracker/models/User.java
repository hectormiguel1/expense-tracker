package com.expense.tracker.models;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Class User
 */
public class User {

  //
  // Fields
  //

  private String uid;
  private String name;
  private List<Receipt> receipts;
  private Map<String, Double> Limits;
  private Map<String, Double> currentExpenditure;
  
  //
  // Constructors
  //
  public User () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of uid
   * @param newVar the new value of uid
   */
  public void setUid (String newVar) {
    uid = newVar;
  }

  /**
   * Get the value of uid
   * @return the value of uid
   */
  public String getUid () {
    return uid;
  }

  /**
   * Set the value of name
   * @param newVar the new value of name
   */
  public void setName (String newVar) {
    name = newVar;
  }

  /**
   * Get the value of name
   * @return the value of name
   */
  public String getName () {
    return name;
  }

  /**
   * Set the value of reciepts
   * @param newVar the new value of reciepts
   */
  public void setReceipts(List<Receipt> newVar) {
    receipts = newVar;
  }

  /**
   * Get the value of reciepts
   * @return the value of reciepts
   */
  public List<Receipt> getReceipts() {
    return receipts;
  }

  /**
   * Set the value of Limits
   * @param newVar the new value of Limits
   */
  public void setLimits (Map<String, Double> newVar) {
    Limits = newVar;
  }

  /**
   * Get the value of Limits
   * @return the value of Limits
   */
  public Map<String, Double> getLimits () {
    return Limits;
  }

  /**
   * Set the value of currentSpenditure
   * @param newVar the new value of currentSpenditure
   */
  public void setCurrentExpenditure(Map<String, Double> newVar) {
    currentExpenditure = newVar;
  }

  /**
   * Get the value of currentSpenditure
   * @return the value of currentSpenditure
   */
  public Map<String, Double> getCurrentExpenditure() {
    return currentExpenditure;
  }

  //
  // Other methods
  //


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(uid, user.uid) && Objects.equals(name, user.name) && Objects.equals(receipts, user.receipts) && Objects.equals(Limits, user.Limits) && Objects.equals(currentExpenditure, user.currentExpenditure);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uid, name, receipts, Limits, currentExpenditure);
  }
}
