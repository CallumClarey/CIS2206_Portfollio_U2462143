package Practical12;


import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Transcript {

    //class attributes
    private int TranscriptId;
    private final LinkedList<Module> ModuleList = new LinkedList<>();

    public Transcript(int TranscriptId) {
        this.TranscriptId = TranscriptId;
    }

    //getters and setters
    public int getTranscriptId() {
        return TranscriptId;
    }
    public void setTranscriptId(int transcriptId) {
        TranscriptId = transcriptId;
    }

    //----------------------------------
    //Transcript manipulation functions
    //---------------------------------
    public Boolean AddModule(Module moduleToAdd) {
        //checks if the module is already in the list
        //Done in 0(N)
        if(ModuleList.contains(moduleToAdd)) return false;

        //adds to list and doesn't worry about anything else if empty
        //done in 0(1)
        if(ModuleList.isEmpty()){
            ModuleList.add(moduleToAdd);
            PrintTranscript();
            return true;
        }

        //gets a list iterator to loop through the link list to insert
        ListIterator<Module> moduleIterator  = ModuleList.listIterator();

        //checks to see if the module iterator has another value
        //this is done in time 0(n)
        while(moduleIterator.hasNext()){
            //check to see if the next module is smaller
            //returns minus 1
            if(moduleToAdd.compareTo(moduleIterator.next()) < 0){
                moduleIterator.previous();
                moduleIterator.add(moduleToAdd);
                PrintTranscript();
                return true;
            }
        }

        ModuleList.add(moduleToAdd);
        //prints the transcript
        PrintTranscript();
        return true;
    }

    //code used to remove the module from the linked list
    public void RemoveModule(Module moduleToRemove) {
        ModuleList.remove(moduleToRemove);
        PrintTranscript();
    }

    //function used to update module grade
    public void UpdateModuleGrade(Module moduleToUpdate, int grade) {
        //checks to see if the module exists
        //Done in time O(n) only can be check via looping through the list
        if(!ModuleList.contains(moduleToUpdate))
        {
            System.out.println("Module does not exist");
            return;
        }

        //remove the module
        ModuleList.remove(moduleToUpdate);
        //update the module grade
        moduleToUpdate.setGrade(grade);
        //add the module back into the list to maintain ordering
        AddModule(moduleToUpdate);
        PrintTranscript();
    }


    //print the current transcript order
    public void PrintTranscript() {
        //prints each module in module list
        for(Module module : ModuleList){
            System.out.println(module);
        }
        PrintAverages();
    }

    //prints the average grade per year
    public void PrintAverages() {
        //loops through every year enum value
        //this print averages in time O(n*m) n the number of years m being number of modules
        for (Year moduleYear : Year.values()) {
            double GradeTotal = 0;
            int count = 0;

            //loops through the module
            for (Module module : ModuleList) {
                //checks to see if the module year is equal to the current
                if (module.GetYear() == moduleYear) {
                    GradeTotal += module.GetGrade();
                    count++;
                }
            }
            //checks to see if the count is not zero and then prints out the average
            if (count > 0) {
                System.out.println(moduleYear + " Average: " + (GradeTotal / count));
            }
        }
    }

    //Testing function
    public List<Module> GetModuleList(){return ModuleList;}
}
