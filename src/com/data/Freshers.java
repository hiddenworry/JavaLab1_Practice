package com.data;

public class Freshers extends Candidates {
    String Graduation_date;
    String Graduation_rank;
    String Education;
    public Freshers(String candidateId, String firstName, String lastName, String dayOfBirth, String phone, String email, String graduation_date, String graduation_rank, String education) {
        super (candidateId, firstName, lastName, dayOfBirth, phone, email, 1);
        Graduation_date = graduation_date;
        Graduation_rank = graduation_rank;
        Education = education;
    }

    protected void showInform() {
        System.out.printf ("|%5s|%16s%16s|%10s|%12s|%16s|%16s|%16s|%16s|\n", CandidateId, firstName, lastName, dayOfBirth, phone, email, Graduation_date, Graduation_rank, Education);
    }
}
