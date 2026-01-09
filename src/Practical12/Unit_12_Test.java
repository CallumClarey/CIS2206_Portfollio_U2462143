package Practical12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Unit_12_Test {

    private Transcript transcript;
    private Module module1;
    private Module module2;
    private Module module3;

    @BeforeEach
    void setUp() {
        //creates new transcript
        transcript = new Transcript(1);

        //Creates 3 new modules
        module1 = new Module("CS101", "Programming", Year.FIRST_YEAR,40, 20);
        module2 = new Module("CS102", "Algorithms", Year.FIRST_YEAR,30, 70);
        module3 = new Module("CS201", "Databases",  Year.SECOND_YEAR,60, 50);
    }

    // -------------------------
    // ADD MODULE TESTS
    // -------------------------

    @Test
    void addModule_successful() {
        assertTrue(transcript.AddModule(module1));
    }

    @Test
    void addModule_duplicateFails() {
        transcript.AddModule(module1);
        assertFalse(transcript.AddModule(module1));
    }

    @Test
    void addModule_maintainsOrderByYearAndGrade() {
        transcript.AddModule(module1);
        transcript.AddModule(module2);
        transcript.AddModule(module3);

        // module2 should come before module1 (same year, higher grade)
        assertEquals(module2, transcript.GetModuleList().get(0));
        assertEquals(module1, transcript.GetModuleList().get(1));
        assertEquals(module3, transcript.GetModuleList().get(2));
    }

    // -------------------------
    // REMOVE MODULE TESTS
    // -------------------------

    @Test
    void removeModule_successful() {
        transcript.AddModule(module1);
        transcript.RemoveModule(module1);

        assertFalse(transcript.GetModuleList().contains(module1));
    }

    // -------------------------
    // UPDATE MODULE TESTS
    // -------------------------

    @Test
    void updateModuleGrade_reordersList() {
        transcript.AddModule(module1);
        transcript.AddModule(module2);

        transcript.UpdateModuleGrade(module1, 90);

        // module1 should now come before module2
        assertEquals(module1, transcript.GetModuleList().get(0));
    }
}

