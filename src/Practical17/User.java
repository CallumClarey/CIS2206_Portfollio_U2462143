package Practical17;


/// Class used to represent a user in the system
public class User {

    //backing fields representing user data
    private String name;
    private String email;
    private int ID;

    public User(String name, String email, int ID){
        this.name = name;
        this.email = email;
        this.ID = ID;
    }

    //returns human-readable format
    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", ID: " + ID;
    }

    //getters and setters for name
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    //getters and setter for email
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    //getter and setters for ID
    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}

}
