package com.data;

public class Experiences extends Candidates {
    int ExpInYear;
    String ProSkill;

    public Experiences(String candidateId, String firstName, String lastName, String dayOfBirth, String phone, String email, int expInYear, String proSkill) {
        super (candidateId, firstName, lastName, dayOfBirth, phone, email, 0);
        ExpInYear = expInYear;
        ProSkill = proSkill;
    }



  @Override
    protected void showInform() {
        System.out.printf ("|%5s|%16s%16s|%10s|%12s|%16s|%4d|%20s|\n", CandidateId, firstName, lastName, dayOfBirth, phone, email, ExpInYear, ProSkill);
    }
}
