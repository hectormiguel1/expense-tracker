package com.expense.tracker.controllers;

import com.expense.tracker.models.Receipt;
import com.expense.tracker.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class ReceiptController
 */
@RestController
public class ReceiptController {

  //
  // Fields
  //

  @Autowired
  private ReceiptService receiptService;
  
  //
  // Constructors
  //
  public ReceiptController() { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of receiptService
   * @param newVar the new value of receiptService
   */
  public void setReceiptService(ReceiptService newVar) {
    receiptService = newVar;
  }

  /**
   * Get the value of receiptService
   * @return the value of receiptService
   */
  public ReceiptService getReceiptService() {
    return receiptService;
  }

  //
  // Other methods
  //

  /**
   * //Todo mapping to create a new receipt at /user/{uid}/receipts
   * //Function will take in a new Receipt object through the request body and add
   * that receipt to the passed UID
   * @param        userUID
   * @param        newReceipt
   */
  public void newReceipt(String userUID, Receipt newReceipt)
  {
  }


  /**
   * //Get Mapping at /user/{uid}/receipts
   * //Function will return all the receipts for the passed UID
   * @return       List<Receipt>
   * @param        userUID
   */
  public List<Receipt> getAllReceipts(String userUID)
  {
  }


  /**
   * //Get mapping at /user/{uid}/{receiptID}
   * //Function will return receipt with receipt UID for user UID
   * @return       Receipt
   * @param        userUID
   * @param        receiptUID
   */
  public Receipt getReceipt(String userUID, String receiptUID)
  {
  }


}
