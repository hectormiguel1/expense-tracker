package com.expense.tracker;
import java.util.HashMap;
import java.util.Map;

import com.expense.tracker.models.User;
import com.expense.tracker.services.StorageService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StorageServiceTest
{

    private StorageService storageService;
    private User user;
    private final String USER_UID = "TestUser";


    @Before
    public void setUp()
    {
        // CreateUser not in setup because of potential user already exists exception
        storageService = new StorageService();
    }

    public HashMap<String, Double> generateExpenditures()
    {
        HashMap<String, Double> expenditure = new HashMap<>();
        expenditure.put("food", 100.0);
        expenditure.put("rent", 1000.0);
        expenditure.put("gas", 100.0);
        return expenditure;
    }

    public HashMap<String, Double> generateLimits()
    {
        HashMap<String, Double> limits = new HashMap<>();
        limits.put("food", 100.0);
        limits.put("rent", 1000.0);
        limits.put("gas", 100.0);
        return limits;
    }


    @Test
    public void createUser()
    {
        user = new User();

        user.setUid(USER_UID);
        user.setName("Test User");

        user.setCurrentExpenditure(generateExpenditures());
        user.setLimits(generateLimits());

        // storageService.saveNewUser(user); Needs to be commented out to do the updateUser test
        // Check for 201 return code?
    }

    @Test
    public void getUserExpenses()
    {
        // Assumes user is in the database, if not call createUser

        String expected = "{gas=100.0, rent=1000.0, food=100.0}";
        Map<String, Double> actual =  storageService.getUserExpenses(USER_UID);

        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void getUserLimit()
    {
        // Assumes user is in the database, if not call createUser

        String expected = "{gas=100.0, rent=1000.0, food=100.0}";
        Map<String, Double> actual =  storageService.getUserLimits(USER_UID);

        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void updateUser() // could create seperate test for updates to Expenditure and limit
    {
        // Assumes user is in the database, if not call createUser

        String expected = "{rent=120.0, food=200.0}";

        HashMap<String, Double> expenditure = new HashMap<>();
        expenditure.put("food", 200.00);
        expenditure.put("rent", 120.00);

        createUser();
        user.setCurrentExpenditure(expenditure);
        storageService.updateUser(user);

        Map<String, Double> actual =  storageService.getUserExpenses(USER_UID);

        Assert.assertEquals(expected, actual.toString());
    }






























    
}
