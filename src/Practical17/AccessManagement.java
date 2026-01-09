package Practical17;


import java.util.HashMap;
import java.util.Map;

/// Class used to handle user permissions
public class AccessManagement {

    //backing hashmap inside a hash map
    private final Map<User, Map<String,String>> UserPermMap = new HashMap<>();

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

        //Time O(1) unless there is a collisions, resulting in worse case O(n)
        if(!UserPermMap.containsKey(user)){
            System.err.println("User does not exist: " + user.getName());
            return false;
        }

        //gets the nested map
        Map<String,String> SystemNameMap = UserPermMap.get(user);
        //This changes the permission on the map
        SystemNameMap.put(systemName, permission);
        UserPermMap.put(user, SystemNameMap);
        return true;
    }


}
