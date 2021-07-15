package com.company.자료구조;

public class StudentInfo {
    private String studentID;
    private String studentName;

    public StudentInfo(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public void setStudentID(String ID) { this.studentID = ID;}

    public void setStudentName(String name){ this.studentName = name; }

    public String getStudentID(){return this.studentID;}

    public String getStudentName(){return this.studentName;}

}
