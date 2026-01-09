package Practical11;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Unit_11_Test {

    @Test
    void testConcertConstructorAndGetters() {
        List<String> artists = Arrays.asList("Artist1", "Artist2");
        LocalDateTime time = LocalDateTime.of(2026, 7, 10, 19, 30);

        Concert concert = new Concert("1234", artists, time);

        //Tests that the getters return the correct value from the constructor
        assertEquals("1234", concert.getConcertId());
        assertEquals(artists, concert.getArtists());
        assertEquals(time, concert.getTime());
    }

    @Test
    void testGetArtistByIndexValid() {
        List<String> artists = Arrays.asList("Artist1", "Artist2");
        Concert concert = new Concert(
                "1234",
                artists,
                LocalDateTime.now()
        );

        //attempts to get valid indexes
        assertEquals("Artist1", concert.getArtists(0));
        assertEquals("Artist2", concert.getArtists(1));
    }

    @Test
    void testGetArtistByIndexInvalid() {
        List<String> artists = List.of("Artist1");
        Concert concert = new Concert(
                "1234",
                artists,
                LocalDateTime.now()
        );

        //attempts to get artists via index that is invalid
        assertNull(concert.getArtists(-1));
        assertNull(concert.getArtists(5));
    }

    @Test
    void testSetters() {
        Concert concert = new Concert(
                "1234",
                List.of("Artist"),
                LocalDateTime.now()
        );

        //checks to see if the setters are working
        concert.setConcertId("1234_UPDATE");
        concert.setArtists(List.of("New Artist"));
        LocalDateTime newTime = LocalDateTime.of(2026, 1, 1, 20, 0);
        concert.setTime(newTime);

        //asserts the expected values
        assertEquals("1234_UPDATE", concert.getConcertId());
        assertEquals("New Artist", concert.getArtists(0));
        assertEquals(newTime, concert.getTime());
    }

    @Test
    void testCompareConcertSameTime() {
        LocalDateTime time = LocalDateTime.of(2025, 6, 1, 18, 0);

        Concert concert1 = new Concert(
                "C005",
                List.of("Artist A"),
                time
        );

        Concert concert2 = new Concert(
                "C006",
                List.of("Artist B"),
                time
        );

        assertTrue(concert1.CompareConcert(concert2));
    }

    @Test
    void testCompareConcertDifferentTime() {
        Concert concert1 = new Concert(
                "C007",
                List.of("Artist A"),
                LocalDateTime.of(2025, 6, 1, 18, 0)
        );

        Concert concert2 = new Concert(
                "C008",
                List.of("Artist B"),
                LocalDateTime.of(2025, 6, 2, 18, 0)
        );

        assertFalse(concert1.CompareConcert(concert2));
    }

}
