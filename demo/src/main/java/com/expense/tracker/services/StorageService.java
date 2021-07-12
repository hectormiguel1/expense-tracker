package com.expense.tracker.services;
import com.expense.tracker.exceptions.UserAlreadyExistsException;
import com.expense.tracker.exceptions.UserDoesNotExistException;
import com.expense.tracker.models.User;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.concurrent.ExecutionException; 


@Service 
public class StorageService { 

    Firestore db = null;
    //File needs to be placed inside src/main/resources/ folder
    private static final String CREDENTIALS_FILE_PATH = "src/main/resources/serviceAccount.json";
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


    public void saveNewUser(User newUser) throws UserAlreadyExistsException {
        String newUserUid = newUser.getUid();
        try {
            if(db.collection("users").document(newUserUid).get().get().exists()){
                throw new UserAlreadyExistsException("User" + newUserUid + " already exists");
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error saving user: " + newUserUid);
        }
        db.collection("users").document(newUserUid).set(newUser);
    }

    public void updateUser(User updatedUser) throws UserDoesNotExistException 
    {
        String updatedUserUid = updatedUser.getUid();
        try {
            if(!db.collection("users").document(updatedUserUid).get().get().exists()){
                throw new UserDoesNotExistException("User" + updatedUserUid + " does not exist");
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getMessage());
            
            System.out.println("Error updating user: " + updatedUserUid);
        }
        db.collection("users").document(updatedUserUid).set(updatedUser);
    }



    }




