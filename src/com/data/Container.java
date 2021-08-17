package com.data;

import util.input.checking.InputChecking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Container {

    List<Interns> Intern_List = new ArrayList<> (  );
    List<Freshers> Fresher_List = new ArrayList<> (  );
    List <Experiences> Experience_List = new ArrayList<> (  );
    List<String> Input = new ArrayList<> ( );
    Scanner sc = new Scanner (System.in);
    public Candidates SearchCandidateById ( List <? extends Candidates> listOfCandidate, String Id) {
        for (Candidates People : listOfCandidate) {
            if (People.getCandidateId ().compareToIgnoreCase (Id) == 0)
                return People;
        }

        return null;
    }// su dung cho check duplicated

    public void addAnInterns() {
        String candidateId, firstName, lastName, dayOfBirth, phone, email, major, semester, universityName;
        System.out.println ( "You are going to add an Intern" );
        do {
            candidateId = InputChecking.getString ("Input Id of Candidate", "Your input is invalid, please input again!!!");
            if ( SearchCandidateById (Intern_List, candidateId) == null)
                    break;
            else System.out.println ( "Sorry this candidate already exit in our data, please try another!!!" );
        } while (true);
        firstName = InputChecking.getString ("Input first name of Candidate", "Your input is invalid, please input again!!!");
        lastName = InputChecking.getString ("Input last name of Candidate", "Your input is invalid, please input again!!!");
        dayOfBirth = InputChecking.checkDate ("Input date of birth of the candidate", "please make sure your input is correct!!!");
        phone = InputChecking.checkPhoneNumber ("Input phone number of the candidate", "please make sure your input is correct, the phone number must be at least 10 digits");
        email = InputChecking.checkEmailAddress ("input email address of the candidate", "please make sure your input is valid email address");
        major = InputChecking.getString ("Input your major", "sorry make sure your input is not empty!!!");
        semester = InputChecking.getString ("Input your major", "sorry make sure your input is not empty!!!");
        universityName = InputChecking.getString ("Input your major", "sorry make sure your input is not empty!!!");
        Intern_List.add (new Interns (candidateId, firstName, lastName, dayOfBirth, phone, email, major, semester, universityName));
    }

    public void addAnExperiences() {
        String candidateId, firstName, lastName, dayOfBirth, phone, email, proSkill;
        int expYears;
        System.out.println ( "You are going to add an Experiences" );
        do {
            candidateId = InputChecking.getString ("Input Id of Candidate", "Your input is invalid, please input again!!!");
            if ( SearchCandidateById (Experience_List, candidateId) == null)
                break;
            else System.out.println ( "Sorry this candidate already exit in our data, please try another!!!" );
        } while (true);

        firstName = InputChecking.getString ("Input first name of Candidate", "Your input is invalid, please input again!!!");
        lastName = InputChecking.getString ("Input last name of Candidate", "Your input is invalid, please input again!!!");
        dayOfBirth = InputChecking.checkDate ("Input date of birth of the candidate", "please make sure your input is correct!!!");
        phone = InputChecking.checkPhoneNumber ("Input phone number of the candidate", "please make sure your input is correct, the phone number must be at least 10 digits");
        email = InputChecking.checkEmailAddress ("input email address of the candidate", "please make sure your input is valid email address");
        expYears = InputChecking.checkYearExp ("Input your experiences years", "sorry make sure your is valid!!!");
        proSkill = InputChecking.getString ("Input your professional skill", "sorry make sure your input is not empty!!!");
        Experience_List .add (new Experiences (candidateId, firstName, lastName, dayOfBirth, phone, email, expYears, proSkill));
    }

    public void addAFresher() {
        System.out.println ( "You are going to add an Fresher" );
        String candidateId, firstName, lastName, dayOfBirth, phone, email, Graduation_date, Graduation_rank, Education;
        do {
            candidateId = InputChecking.getString ("Input Id of Candidate", "Your input is invalid, please input again!!!");
            if ( SearchCandidateById (Fresher_List, candidateId) == null)
                break;
            else System.out.println ( "Sorry this candidate already exit in our data, please try another!!!" );
        } while (true);
        firstName = InputChecking.getString ("Input first name of Candidate", "Your input is invalid, please input again!!!");
        lastName = InputChecking.getString ("Input last name of Candidate", "Your input is invalid, please input again!!!");
        dayOfBirth = InputChecking.checkDate ("Input date of birth of the candidate", "please make sure your input is correct!!!");
        phone = InputChecking.checkPhoneNumber ("Input phone number of the candidate", "please make sure your input is correct, the phone number must be at least 10 digits");
        email = InputChecking.checkEmailAddress ("input email address of the candidate", "please make sure your input is valid email address");
        Graduation_date = InputChecking.checkDate ("Input your graduation date", "Sorry, your input is invalid, make sure it is valid date");
        Graduation_rank = InputChecking.checkRankOfGraduation ("Input your graduation rank", "sorry make sure your rank in set of 4 value: Excellence,Good, Fair, Poor");
        Education = InputChecking.getString ("Input your school/ center that you has been graduated", "please make sure this filed is not empty");
        Fresher_List.add (new Freshers (candidateId, firstName, lastName, dayOfBirth, phone, email, Graduation_date, Graduation_rank, Education));
    }

    public void searchCandidateByName() {
        String name = InputChecking.getString ("Input Candidate name (First name or Last name):", "sorry, make sure your input is not empty!!!");
        int CandidateType = InputChecking.getAnIntegerInRange ("Input type of candidate: ","Make sure your candidate types is from 0 to 2", 0 , 2);
        List <Candidates> SearchingResult = new ArrayList<> (  );
        switch ( CandidateType ){
            case 0: SearchingResult = searchCandidateByName ( Experience_List, name );break;
            case 1: SearchingResult  = searchCandidateByName ( Fresher_List, name ); break;
            case 2: SearchingResult = searchCandidateByName ( Intern_List, name ); break;
        }
        if ( !SearchingResult.isEmpty ()){
            System.out.println ("The candidates found:" );
            displayCandidateList (SearchingResult);
        } else System.out.println ( "Not found!!!" );
    }
    public List<Candidates> searchCandidateByName(List <? extends Candidates> SearchingList, String name) {
        List <Candidates> SearchingResult = new ArrayList<> (  );
        for ( Candidates People : SearchingList) {
            if ( People.getFirstName ().indexOf (name) >= 0 || People.getLastName ().indexOf (name) >= 0 ) //tra ve so >= 0 neu chuoi xuat hien trong ten, con -1 neu khong xuat hhien
                SearchingResult.add (People);
        }
        return SearchingResult;
    }

    public void displayCandidateList() {
        System.out.println ( "===========EXPERIENCE CANDIDATE============" );
        displayCandidatesListByName (Experience_List);
        System.out.println ( "==========FRESHER CANDIDATE==============");
        displayCandidatesListByName (Fresher_List);
        System.out.println ( "===========INTERN CANDIDATE==============" );
       displayCandidatesListByName (Intern_List);


    }
    private void displayCandidatesListByName (List< ? extends Candidates> DisplaysList) {
        if (DisplaysList.isEmpty ())
            System.out.println ( "The list is Empty!!!" );
        DisplaysList.forEach (p -> System.out.println ( p.getFirstName () +" " + p.getLastName () ));
    }
    private void displayCandidateList(List< ? extends Candidates> DisplaysList) {
        if ( DisplaysList.isEmpty () )
            System.out.println ( "Empty!!!" );
        DisplaysList.forEach (p -> p.showInform ());
    }
}