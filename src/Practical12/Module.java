package Practical12;


// Class Record used to represent a module
public class Module implements Comparable<Module> {

    //class attributes
    private final String moduleCode;
    private final String moduleName;
    private final Year year;
    private final int credits;
    private int grade;

    //class constructor
    public Module(String moduleCode, String moduleName, Year year, int credits, int grade)
    {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.year = year;
        this.credits = credits;
        this.grade = grade;
    }

    //getters
    public String GetModuleCode() {return moduleCode;}
    public String GetModuleName() {return moduleName;}
    public Year GetYear() {return year;}
    public int GetCredits() {return credits;}
    public int GetGrade() {return grade;}

    //setters
    public void setGrade(int grade) {this.grade = grade;}


    //to string representation
    @Override
    public String toString() {
        return String.format("Module Code:%s | Module Name: %s | Year:%s | Credits:%d | Grade:%d",
                moduleCode, moduleName, year, credits, grade);
    }

    @Override
    public int compareTo(Module other) {
        //returns negative if less than
        //positive if greater than
        //0 for equal
        int YearCompare = this.year.compareTo(other.year);
        //doesn't check the credits because year is different
        if (YearCompare != 0) return YearCompare;
        //checks the credits highest to lowest
        return Double.compare(other.grade, this.grade);
    }
}
