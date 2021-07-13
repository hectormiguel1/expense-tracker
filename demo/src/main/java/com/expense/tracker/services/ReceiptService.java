package com.expense.tracker.services;

import com.expense.tracker.models.Item;
import com.expense.tracker.models.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class ReceiptService
 * Service which provides functionality around the reciepts stored for the user.
 * 
 */
@Service
public class ReceiptService {

  public void setStorageService(StorageService storageService) {
    this.storageService = storageService;
  }

  @Autowired
  private StorageService storageService;



  //
  // Fields
  //

  
  //
  // Constructors
  //
  public ReceiptService() { };
  
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
   * //Creates new Receipt
   * @return       Receipt
   * @param        newReceipt
   * @param        userUID //User to which the receipt belongs to.
   * 
   */
  public Receipt createReceipt(Receipt newReceipt, String userUID)
  {

  }


  /**
   * //Returns all the receipts for passed UID, throws UserNotFoundException if the
   * passed UID is not in the database.
   * @return       List<Receipt>
   * @param        userUID
   */

  public List<Receipt> getReceipts(String userUID)
  {
    return storageService.getReceipts(userUID);
  }


  /**
   * ///Returns all the items on the receipt.
   * @return       List<Item>
   * @param        userUID
   * @param        receiptUID
   */
  public List<Item> getItems_(String  userUID, String receiptUID)
  {
    return storageService.getReceiptItems(userUID,receiptUID);
  }


  public Receipt getReceipt(String userUID, String receiptUID) {
  }
}
