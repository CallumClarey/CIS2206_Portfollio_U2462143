package Practical17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Unit_17_Test {

    private AccessManagement accessManagement;
    private User user;

    @BeforeEach
    void Setup() {
        //creates object before each test
        accessManagement = new AccessManagement();
        user = new User("Alice","Alice@gmail.com",12345);
    }

    // ---------------------------------
    // Tests for adding users
    // ---------------------------------

    @Test
    void TestAddUserSuccessful() {
        //Tests whether add user is successful
        boolean result = accessManagement.AddUser(user, "SystemA", "READ");
        assertTrue(result, "User should be added successfully");
    }

    @Test
    void TestAddUserDuplicateFails() {
        accessManagement.AddUser(user, "SystemA", "READ");

        boolean result = accessManagement.AddUser(user, "SystemB", "WRITE");

        assertFalse(result, "Duplicate users should not be allowed");
    }

    // ---------------------------------
    // Tests for deleting users
    // ---------------------------------

    @Test
    void TestDeleteUserSuccessful() {
        accessManagement.AddUser(user, "SystemA", "READ");

        boolean result = accessManagement.DeleteUser(user);

        assertTrue(result, "Existing user should be deleted");
    }

    @Test
    void TestDeleteUserNonExistentFails() {
        boolean result = accessManagement.DeleteUser(user);

        assertFalse(result, "Deleting non-existent user should fail");
    }

    // ---------------------------------
    // Tests for updating users
    // ---------------------------------

    @Test
    void TestUpdateUserExistingPermission() {
        accessManagement.AddUser(user, "SystemA", "READ");

        boolean result = accessManagement.UpdateUser(user, "SystemA", "WRITE");

        assertTrue(result, "Existing permission should be updated");
    }

    @Test
    void TestUpdateUserAddsNewSystemPermission() {
        accessManagement.AddUser(user, "SystemA", "READ");

        boolean result = accessManagement.UpdateUser(user, "SystemB", "ADMIN");

        assertTrue(result, "New system permission should be added");
    }

    @Test
    void TestUpdateUserNonExistentFails() {
        boolean result = accessManagement.UpdateUser(user, "SystemA", "READ");

        assertFalse(result, "Updating non-existent user should fail");
    }

    // ---------------------------------
    // Test for multiple users
    // ---------------------------------

    @Test
    void TestMultipleUserPermissions() {
        User bob = new User("Bob","Bob@gmail.com",12345);

        accessManagement.AddUser(user, "SystemA", "READ");
        accessManagement.AddUser(bob, "SystemA", "WRITE");

        assertTrue(accessManagement.UpdateUser(user, "SystemA", "ADMIN"));
        assertTrue(accessManagement.UpdateUser(bob, "SystemA", "READ"));
    }
}
