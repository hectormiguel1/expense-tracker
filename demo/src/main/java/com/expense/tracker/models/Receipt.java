package com.expense.tracker.models;

import com.google.api.client.util.DateTime;

import java.util.List;

/**
 * Class Receipt
 */
public class Receipt {

  //
  // Fields
  //

  private String imageURL;
  private List<Item> items;
  private Double total;
  private String storeName;
  private String storeAddress;
  private DateTime date;
  private String uid;
  
  //
  // Constructors
  //
  public Receipt() { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of imageURL
   * @param newVar the new value of imageURL
   */
  public void setImageURL (String newVar) {
    imageURL = newVar;
  }

  /**
   * Get the value of imageURL
   * @return the value of imageURL
   */
  public String getImageURL () {
    return imageURL;
  }

  /**
   * Set the value of items
   * @param newVar the new value of items
   */
  public void setItems (List<Item> newVar) {
    items = newVar;
  }

  /**
   * Get the value of items
   * @return the value of items
   */
  public List<Item> getItems () {
    return items;
  }

  /**
   * Set the value of total
   * @param newVar the new value of total
   */
  public void setTotal (Double newVar) {
    total = newVar;
  }

  /**
   * Get the value of total
   * @return the value of total
   */
  public Double getTotal () {
    return total;
  }

  /**
   * Set the value of storeName
   * @param newVar the new value of storeName
   */
  public void setStoreName (String newVar) {
    storeName = newVar;
  }

  /**
   * Get the value of storeName
   * @return the value of storeName
   */
  public String getStoreName () {
    return storeName;
  }

  /**
   * Set the value of storeAddress
   * @param newVar the new value of storeAddress
   */
  public void setStoreAddress (String newVar) {
    storeAddress = newVar;
  }

  /**
   * Get the value of storeAddress
   * @return the value of storeAddress
   */
  public String getStoreAddress () {
    return storeAddress;
  }

  /**
   * Set the value of date
   * @param newVar the new value of date
   */
  public void setDate (DateTime newVar) {
    date = newVar;
  }

  /**
   * Get the value of date
   * @return the value of date
   */
  public DateTime getDate () {
    return date;
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
