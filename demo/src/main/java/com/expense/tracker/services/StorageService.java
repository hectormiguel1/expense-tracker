package com.expense.tracker.services;
import com.expense.tracker.exceptions.ReceiptDoesNotExistException;
import com.expense.tracker.exceptions.UserAlreadyExistsException;
import com.expense.tracker.exceptions.UserDoesNotExistException;
import com.expense.tracker.models.Item;
import com.expense.tracker.models.Receipt;
import com.expense.tracker.models.User;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException; 


@Service 
public class StorageService { 

    Firestore db = null;
    //File needs to be placed inside src/main/resources/ folder
    private static final String CREDENTIALS_FILE_PATH = "src/main/resources/serviceAccount.json";

    //Initializes Firestore client
    //
    public StorageService() {
        try{
            FileInputStream credentials = new FileInputStream(CREDENTIALS_FILE_PATH);
            FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(credentials)).build();
            FirebaseApp.initializeApp(options);
            this.db = FirestoreClient.getFirestore();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Saves a new user to the Firestore database. 
    // @param user User object to save
    // @return The timestamp when the update was made, null if there was an error
    public String saveNewUser(User newUser) throws UserAlreadyExistsException {
        String newUserUid = newUser.getUid();
        try {
            if(db.collection("users").document(newUserUid).get().get().exists()){
                throw new UserAlreadyExistsException("User" + newUserUid + " already exists");
            }
            var writeResult = db.collection("users").document(newUserUid).set(newUser);
            return writeResult.get().getUpdateTime().toString();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error saving user: " + newUserUid);
        }
        return null;

    }

    //Updates a user in the Firebase 
    // @param user User object to update
    // @return The timestamp when the update was made, null if there was an error
    public String updateUser(User updatedUser) throws UserDoesNotExistException 
    {
        String updatedUserUid = updatedUser.getUid();
        try {
            if(!db.collection("users").document(updatedUserUid).get().get().exists()){
                throw new UserDoesNotExistException("User" + updatedUserUid + " does not exist");
            }
            var writeResult =db.collection("users").document(updatedUserUid).set(updatedUser);
        return writeResult.get().getUpdateTime().toString();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());

            System.out.println("Error updating user: " + updatedUserUid);
        }

        return null;
        
    }

    Map<String, Double> getUserExpenses(String userUid) throws UserDoesNotExistException {
        try{
            if(!db.collection("users").document(userUid).get().get().exists()){
                throw new UserDoesNotExistException("User" + userUid + " does not exist");
            }
            var query = db.collection("users").document(userUid).collection("expenses").get().get();
            var expenses = new HashMap<String, Double>();
            for (var expense : query) {
                expenses.put(expense.getId(), expense.getDouble("amount"));
            }
            return expenses;
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error getting expenses for user: " + userUid);
        }
        return null;
    }

    Map<String, Double> getUserLimits(String userUid) throws UserDoesNotExistException {
        try{
            if(!db.collection("users").document(userUid).get().get().exists()){
                throw new UserDoesNotExistException("User" + userUid + " does not exist");
            }
            var query = db.collection("users").document(userUid).collection("limits").get().get();
            var limits = new HashMap<String, Double>();
            for (var limit : query) {
                limits.put(limit.getId(), limit.getDouble("amount"));
            }
            return limits;
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error getting limits for user: " + userUid);
        }
        return null;
    }
    
        

    List<Receipt> getReceipts(String userUid) throws UserDoesNotExistException {
        try {
            if(!db.collection("users").document(userUid).get().get().exists()){
                throw new UserDoesNotExistException("User" + userUid + " does not exist");
            }
            var recieptDocuments = db.collection("users").document(userUid).collection("receipts").get().get().getDocuments();
            List<Receipt> receiptList = new ArrayList<>();
            for(var document : recieptDocuments) {
                receiptList.add(document.toObject(Receipt.class));
            }
            return receiptList;

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error getting user: " + userUid);
        }
        return null;
    }

    public String saveReceipt(Receipt receipt, String userUID) throws UserDoesNotExistException {
        try {
            if(!db.collection("users").document(userUID).get().get().exists()){
                throw new UserDoesNotExistException("User" + userUID + " does not exist");
            }
            var writeResult = db.collection("users").document(userUID).collection("receipts").document(receipt.getUid()).set(receipt);
            return writeResult.get().getUpdateTime().toString();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error saving receipt: " + receipt.getUid());
        }
        return null;
    }

    public List<Item> getRecieptItems(String userUID, String receiptUID) throws UserDoesNotExistException, ReceiptDoesNotExistException {
        try {
            if(!db.collection("users").document(userUID).get().get().exists()){
                throw new UserDoesNotExistException("User" + userUID + " does not exist");
            }
            if(!db.collection("users").document(userUID).collection("receipts").document(receiptUID).get().get().exists()){
                throw new ReceiptDoesNotExistException("Receipt" + receiptUID + " does not exist");
            }
            var items = db.collection("users").document(userUID).collection("receipts").document(receiptUID).collection("items").get().get().getDocuments();
            List<Item> itemList = new ArrayList<>();
            for(var document : items) {
                itemList.add(document.toObject(Item.class));
            }
            return itemList;
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error getting items: " + userUID + " " + receiptUID);
        }
        return null;
    }

    }


    
        





