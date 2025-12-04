package Practical17;


import java.util.HashMap;
import java.util.Map;

/// Class used to handle user permissions
public class AccessManagement {

    //backing hashmap inside a hash map
    private Map<User, Map<String,String>> UserPermMap;

    /// Takes user as param and adds to the list so long as it is unique
    public Boolean AddUser(User user, String systemName, String permission){
        //This is done in O(n)
        //Check if the user exists in the system
        if(UserPermMap.containsKey(user)){
            System.err.println("User already exists: " + user.getName());
            return false;
        }

        //Creates new map
        //all of these achieved in 0(1)
        HashMap<String,String> UserPerm = new HashMap<>();
        UserPerm.put(systemName, permission);
        UserPermMap.put(user,UserPerm);
        //return true because successful
        return true;
    }

    //Function used to delete users from the system
    //Function achieved in a min time of O(2) due to the double access of the hashmap
    //Worse case
    public Boolean DeleteUser(User user){
        //check if user exists
        if(!UserPermMap.containsKey(user)){
            System.err.println("User does not exist: " + user.getName());
            return false;
        }
        //removes the user at this key
        UserPermMap.remove(user);
        return true;
    }


    /// function used to update user values
    public Boolean UpdateUser(User user, String systemName, String permission){
        if(!UserPermMap.containsKey(user)){
            System.err.println("User does not exist: " + user.getName());
            return false;
        }

        return true;
    }


}
