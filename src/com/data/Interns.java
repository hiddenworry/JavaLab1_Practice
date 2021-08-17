package com.data;

public class Interns extends Candidates{
    String major;
    String semester;
    String universityName;
    public Interns(String candidateId, String firstName, String lastName, String dayOfBirth, String phone, String email, String major, String semester, String universityName) {
        super (candidateId, firstName, lastName, dayOfBirth, phone, email, 2 );
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }



    protected void showInform() {
        System.out.printf ("|%5s|%16s%16s|%10s|%12s|%16s|%16s|%16s|%16s|\n", CandidateId, firstName, lastName, dayOfBirth, phone, email, major, semester, universityName);
    }
}
