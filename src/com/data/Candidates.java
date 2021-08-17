package com.data;

public abstract class Candidates {
    protected String CandidateId;
    protected String firstName;
    protected String lastName;
    protected String dayOfBirth;
    protected String phone;
    protected String email;
    protected int CandidateType;

    public Candidates(String candidateId, String firstName, String lastName, String dayOfBirth, String phone, String email, int candidateType) {
        CandidateId = candidateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.phone = phone;
        this.email = email;
        CandidateType = candidateType;
    }

    public String getCandidateId() {
        return CandidateId;
    }

    public void setCandidateId(String candidateId) {
        CandidateId = candidateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidateType() {
        return CandidateType;
    }

    public void setCandidateType(int candidateType) {
        CandidateType = candidateType;
    }
    protected abstract void showInform() ;
}
