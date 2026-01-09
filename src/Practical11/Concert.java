package Practical11;

import java.time.LocalDateTime;
import java.util.List;

/// Class used to represent concerts in the booking system
public class Concert
{
    //Class attributes
    private String concertId;
    private List<String> artists;
    private LocalDateTime time;

    // constructor
    public Concert(String concertId, List<String> artists, LocalDateTime time) {
        this.concertId = concertId;
        this.artists = artists;
        this.time = time;
    }

    //Class getters
    public String getConcertId() {
        return concertId;
    }

    public List<String> getArtists() {
        return artists;
    }

    //allows the artist to be returned via index
    public String getArtists(int index){
        if (index >= 0 && index < artists.size()) {
            return artists.get(index);
        }
        return null;
    }
    public LocalDateTime getTime() {
        return time;
    }

    //---------------------------------------
    //Class setters
    //----------------------------------------
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public void setConcertId(String concertId) {
        this.concertId = concertId;
    }

    //-------------------------------------
    //Utility Functions
    //-------------------------------------

    //To string representation
    @Override
    public String toString() {
        return "Concert Id: " + concertId + ", Artists: " + artists.toString() + ", Time: " + time;
    }

    //compare the concerts
    public boolean CompareConcert(Concert concert){
        return concert.time.equals(this.time);
    }
}
