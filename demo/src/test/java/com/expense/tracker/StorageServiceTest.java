package com.expense.tracker;
import java.util.HashMap;

import com.expense.tracker.models.User;
import com.expense.tracker.services.StorageService;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Test;

public class StorageServiceTest {

    StorageService storageService;

    @Before
    public void setUp() {
        storageService = new StorageService();
    }

    @Test
    public void testGetUser() {
        HashMap<String, Double> expenditure = new HashMap<>();
        expenditure.put("food", 100.0);
        expenditure.put("rent", 1000.0);
        expenditure.put("gas", 100.0);
        HashMap<String, Double> limits = new HashMap<>();
        limits.put("food", 100.0);
        limits.put("rent", 1000.0);
        limits.put("gas", 100.0);

        User user = new User();
        user.setUid("TestUser");
        user.setName("Test User");
        user.setCurrentExpenditure(expenditure);
        user.setLimits(limits);

        storageService.saveNewUser(user);
        var expected = User();
    }


    
}
