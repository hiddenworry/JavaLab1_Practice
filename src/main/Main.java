package main;

import Uti.Menu;
import com.data.Candidates;
import com.data.Container;
import util.input.checking.InputChecking;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Play ();
    }
    public static void Play() {
        Container CandidatesList = new Container ();

        int  choice;
        Menu menu =  new Menu ("CANDIDATE MANAGEMENT SYSTEM");
        menu.addOptions ("1. Experience");
        menu.addOptions ("2. Fresher");
        menu.addOptions ("3. Internship");
        menu.addOptions ("4. Searching");
        menu.addOptions ("5. Exit");
        do {
            menu.printMenu ();
            System.out.println ( "(Please choose 1 to Create Experience Candidate, 2 to Create Fresher Candidate, 3 to Internship Candidate, 4 to Searching and 5 to Exit program)." );
            choice = menu.getChoice ();
            switch (choice) {
                case 1:
                         do
                             CandidatesList.addAnExperiences ();
                          while (ContinueMessage ());
                         CandidatesList.displayCandidateList ();
                         break;
                case 2:
                        do
                            CandidatesList.addAFresher ();
                         while (ContinueMessage ());
                        CandidatesList.displayCandidateList ();
                        break;
                case 3:
                        do
                            CandidatesList.addAnInterns ();
                        while (ContinueMessage ());
                        CandidatesList.displayCandidateList ();
                        break;
                case 4:
                    CandidatesList.searchCandidateByName ();
                    break;
                case 5:
                    System.out.println ("Good bye!!!" );
                    break;
            }
        } while (choice>=1 && choice <= 5 );




    }
    public static boolean ContinueMessage() {   String input;
        do {
             input = InputChecking.getString ("Do you want to continue (Y/N)?","Please make sure your input is not empty!!!");
             if ( input.equalsIgnoreCase ("Y") || input.equalsIgnoreCase ("yes") )
                 return true;
             else if (input.equalsIgnoreCase ("N")|| input.equalsIgnoreCase ("no"))
                 return false;
             else System.out.println ( "Please make sure your input is correct" );
        } while ( true );
    /// hàm này trả về true false tương ứng với giá trị Yes hoặc No để báo cho chương trình biết có được tiếp tục nhập dữ liệu hay không
    }

}
