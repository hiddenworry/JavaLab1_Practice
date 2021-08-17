package Uti;

import util.input.checking.InputChecking;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    String title;
    List <String> Options = new ArrayList<> (  );

    public Menu(String title) {
        this.title = title;
    }
    public void addOptions(String Option) {
        Options.add (Option);
    }
    public void printMenu() {
        System.out.println ("=============================================================" );
        System.out.println ( title );
        Options.forEach (p -> System.out.println (p.toString () ));
    }
    public int getChoice() {
        return  (int)InputChecking.getANumber ("Input your choices here", "Invalid choice, please input again");
    }
}
