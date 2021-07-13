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

    final private String USER_COLLECTION = "users";

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
            if(db.collection(USER_COLLECTION).document(newUserUid).get().get().exists()){
                throw new UserAlreadyExistsException("User" + newUserUid + " already exists");
            }
            var writeResult = db.collection(USER_COLLECTION).document(newUserUid).set(newUser);
            return writeResult.get().getUpdateTime().toString();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error saving user: " + newUserUid);
        }
        return null;
    }

    //Returns the User from DB with UID = userUID
    public User getUser(String userUid) throws UserDoesNotExistException {
        try {
            var user = db.collection(USER_COLLECTION).document(userUid).get().get();
            if(user.exists()) {
                return user.toObject(User.class);
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
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
            if(!db.collection(USER_COLLECTION).document(updatedUserUid).get().get().exists()){
                throw new UserDoesNotExistException("User" + updatedUserUid + " does not exist");
            }
            var writeResult =db.collection(USER_COLLECTION).document(updatedUserUid).set(updatedUser);
        return writeResult.get().getUpdateTime().toString();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());

            System.out.println("Error updating user: " + updatedUserUid);
        }

        return null;
        
    }
   
    public Map<String, Double> getUserExpenses(String userUid) throws UserDoesNotExistException {
        try{
            if(!db.collection(USER_COLLECTION).document(userUid).get().get().exists()){
                throw new UserDoesNotExistException("User" + userUid + " does not exist");
            }
            var query = db.collection(USER_COLLECTION).document(userUid).get().get().toObject(User.class);
            if(query != null) {
                return query.getCurrentExpenditure();
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error getting expenses for user: " + userUid);
        }
        return null;
    }

    public Map<String, Double> getUserLimits(String userUid) throws UserDoesNotExistException {
        try{
            if(!db.collection(USER_COLLECTION).document(userUid).get().get().exists()){
                throw new UserDoesNotExistException("User" + userUid + " does not exist");
            }
            var query = db.collection(USER_COLLECTION).document(userUid).get().get().toObject(User.class);
            if(query != null) {
                return query.getLimits();
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error getting limits for user: " + userUid);
        }
        return null;
    }
    
        

    public List<Receipt> getReceipts(String userUid) throws UserDoesNotExistException {
        try {
            if(!db.collection(USER_COLLECTION).document(userUid).get().get().exists()){
                throw new UserDoesNotExistException("User" + userUid + " does not exist");
            }
            var query = db.collection(USER_COLLECTION).document(userUid).get().get().toObject(User.class);
            if(query != null) {
                return query.getReceipts();
            }

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error getting user: " + userUid);
        }
        return null;
    }

    public String saveReceipt(Receipt receipt, String userUID) throws UserDoesNotExistException {
        try {
            if(!db.collection(USER_COLLECTION).document(userUID).get().get().exists()){
                throw new UserDoesNotExistException("User" + userUID + " does not exist");
            }
            var dbUser = db.collection(USER_COLLECTION).document(userUID).get().get().toObject(User.class);
            if(dbUser != null) {
                dbUser.getReceipts().add(receipt);
                var result = db.collection(USER_COLLECTION).document(userUID).set(dbUser);
                return result.get().getUpdateTime().toString();
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error saving receipt: " + receipt.getUid());
        }
        return null;
    }

    public List<Item> getReceiptItems(String userUID, String receiptUID) throws UserDoesNotExistException, ReceiptDoesNotExistException {
        try {
            if(!db.collection(USER_COLLECTION).document(userUID).get().get().exists()){
                throw new UserDoesNotExistException("User" + userUID + " does not exist");
            }
            var query = db.collection(USER_COLLECTION).document(userUID).get().get().toObject(User.class);
            List<Item> itemList = new ArrayList<>();
            if(query != null) {
                for (var receipt : query.getReceipts()) {
                    if (receipt.getUid().equals(receiptUID)) {
                        itemList.addAll(receipt.getItems());
                    }
                }
                return itemList;

            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error getting items: " + userUID + " " + receiptUID);
        }
        return null;
    }

    }


    
        





