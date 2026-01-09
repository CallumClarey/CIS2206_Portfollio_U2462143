package Practical11;

public class BookingSystem {

    //basic information
    private int VenueId;
    private String Location;

    //default constructor
    public BookingSystem(int venueId, String location) {
        VenueId = venueId;
        Location = location;
    }

    //------------------------------------
    //Basic getters and setters
    //-------------------------------------
    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getVenueId() {
        return VenueId;
    }

    public void setVenueId(int venueId) {
        VenueId = venueId;
    }

    //------------------------------------
    //Array List implementation
    //------------------------------------
    //backing array
    private Concert[] concertBackingField = new Concert[7];
    private int count = 0;


    //Function used to schedule concerts
    //returns true if value added false if not
    public boolean ScheduleConcert(Concert concertToAdd) {
        //checks to see if the concert is already scheduled
        if (Contains(concertToAdd)) return false;

        //check if the array needs resizing
        if (concertBackingField.length == count){
            //make the list bigger
            Concert[] newConcerts = new Concert[concertBackingField.length + 7];
            //loop through and add each item back into the new concert
            //this will be done in time O(N) due to the need to read and write to the new array
            System.arraycopy(concertBackingField, 0, newConcerts, 0, count);
            //Override concert backing field
            concertBackingField = newConcerts;
        };

        //the index to insert the value at
        //this is done in O(n)
        int insertIndex = 0;
        while (insertIndex < count && concertBackingField[insertIndex].getTime().isBefore(concertToAdd.getTime()))
        {
            insertIndex++;
        }

        //Shift to right
        //This is done in O(n) worse case
        for (int i = count; i > insertIndex; i--) {
            concertBackingField[i] = concertBackingField[i - 1];
        }

        //add the concert
        concertBackingField[insertIndex] = concertToAdd;
        count++;
        //return true
        return true;
    }


    //allows for the removal of a concert
    public boolean CancelConcert(Concert concertToCancel) {

        //loop through the list and finds the concert to set to null
        //returns false if it can not find it
        //Finding by value in O(N) time not ideal
        for (int i = 0; i < concertBackingField.length - 1; i++) {
            if(concertBackingField[i].equals(concertToCancel)){
                //removes the concert
                concertBackingField[i] = null;
            }
            else return false;
        }

        //this is done in O(n*2) time as is contains two for loops
        //worse case is first item is removed
        for (int i = 0; i < concertBackingField.length - 1; i++) {
            //find the null value
            if (concertBackingField[i] == null){
                //loop through the list and find the values after the null
               for (int x = i; x < concertBackingField.length - 1; x++) {
                    //caches the current value and the next one
                    Concert valueToInsert = concertBackingField[x + 1];
                    concertBackingField[x] = valueToInsert;
                    concertBackingField[x + 1] = null;
               }
            }
        }

        //returns true to say the concert is removed
        return true;
    }


    //O(1) Indexing
    //allows for the concert to be retrieved via indexing
    public Concert GetConcert(int index){
        if(index >= concertBackingField.length) return null;
        return concertBackingField[index];
    }

    //checks to see if the value is contained
    private boolean Contains(Concert containsConcert){
        //this is done in time O(N) as every item in the list has to be checked
        for(var concert : concertBackingField) {
            if(concert.equals(containsConcert)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        //creates new string builder
        StringBuilder str = new StringBuilder();
        //loops through all the converts
        for (var concert : concertBackingField) {
            str.append(concert.toString());
        }
        //returns the concatenated string
        return str.toString();
    }


}
