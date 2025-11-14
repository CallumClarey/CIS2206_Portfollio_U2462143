package Practical12;


/// Class used to represent a module
public class Module implements Comparable<Module>{

    //class attributes
    //string variables
    private String _moduleCode;
    private String _moduleName;
    private String _year;
    //int variables
    private int _credits;
    private int _grade;


    @Override
    public String toString(){
        return String.format("Module Code:%s\n Module Name: %s\n Year:%s\n Credits:%d\n Grade:%d",
                _moduleCode, _moduleName, _year,_credits,_grade);
    }

    @Override
    public int compareTo(Module o) {
        return 0;
    }

    // Getters and Setters

    public String getModuleCode() {return _moduleCode;}

    public void setModuleCode(String moduleCode) {this._moduleCode = moduleCode;}

    public String getModuleName() {return _moduleName;}

    public void setModuleName(String moduleName) {this._moduleName = moduleName;}

    public String getYear() {return _year;}

    public void setYear(String year) {this._year = year;}

    public int getCredits() {return _credits;}

    public void setCredits(int credits) {this._credits = credits;}

    public int getGrade() {return _grade;}

    public void setGrade(int grade) {this._grade = grade;}







}
