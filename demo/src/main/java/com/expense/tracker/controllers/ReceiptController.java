
package com.expense.tracker.controllers;

import com.expense.tracker.models.Receipt;
import com.expense.tracker.services.ReceiptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class ReceiptController
 */
@RestController
public class ReceiptController {

  @Autowired
  private ReceiptService receiptService;

  final Logger log = LoggerFactory.getLogger(ReceiptController.class);

  public ReceiptController() { };

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

  /**
   * //Todo mapping to create a new receipt at /user/{uid}/receipts
   * //Function will take in a new Receipt object through the request body and add
   * that receipt to the passed UID
   * @param        uid
   * @param        newReceipt
   */
  @PutMapping("/user/{uid}/receipt")
  @CrossOrigin
  public void newReceipt(@PathVariable String uid, Receipt newReceipt) {
    log.info("Adding Receipt to user " + uid + " receipt data: " +newReceipt.toString() );
    receiptService.createReceipt(newReceipt,uid);
  }


  /**
   * //Get Mapping at /user/{uid}/receipts
   * //Function will return all the receipts for the passed UID
   * @return       List<Receipt>
   * @param        uid
   */
  @GetMapping("user/{uid}/receipts")
  @CrossOrigin
  public List<Receipt> getAllReceipts(@PathVariable String uid) {
    log.info("Getting Receipts for user: " + uid);
    return receiptService.getReceipts(uid);
  }


  /**
   * //Get mapping at /user/{uid}/{receiptID}
   * //Function will return receipt with receipt UID for user UID
   * @return       Receipt
   * @param        uid
   * @param        receiptUID
   */
  @GetMapping("user/{uid}/receipt/{receiptUID}")
  @CrossOrigin
  public Receipt getReceipt(@PathVariable String uid, @PathVariable String receiptUID) {
    log.info("Getting Receipt " + receiptUID + " for user " + uid);
    return receiptService.getReceipt(uid,receiptUID);
  }


}
