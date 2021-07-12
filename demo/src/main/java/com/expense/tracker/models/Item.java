package com.expense.tracker.models;

/**
 * Class Item
 */
public class Item {

  //
  // Fields
  //

  private Category category;
  private String name;
  private Double price;
  private String uid;
  
  //
  // Constructors
  //
  public Item () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of category
   * @param newVar the new value of category
   */
  public void setCategory (Category newVar) {
    category = newVar;
  }

  /**
   * Get the value of category
   * @return the value of category
   */
  public Category getCategory () {
    return category;
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
   * Set the value of price
   * @param newVar the new value of price
   */
  public void setPrice (Double newVar) {
    price = newVar;
  }

  /**
   * Get the value of price
   * @return the value of price
   */
  public Double getPrice () {
    return price;
  }

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

  //
  // Other methods
  //

}
