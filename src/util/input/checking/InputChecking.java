package util.input.checking;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class InputChecking  {
    private static Scanner sc = new Scanner (System.in);







    public static String checkDate (String Msg, String errorMsg) {
        String date = "";
        boolean isDate = false;
        do {
            try {
                System.out.println (Msg);
                date = sc.next ( ).trim ( );
                isDate = isValidDate (date, "dd/MM/yyyy");
                if (!isDate) throw new Exception ( );
            } catch (Exception e) {
                System.out.println (errorMsg);
            }
        } while (!isDate);
        return date;
    }

    private static boolean isValidDate (String dateInput, String format) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat (format);
        dateFormat.setLenient (false);
        final Date lowerDate = dateFormat.parse ("1/1/1900");
        try {
            Date date = dateFormat.parse (dateInput);  // hàm này để check ngày user input vào có valid hay không, data.after(new date)
            if (date.after (new Date ( )) || date.before (lowerDate))              // dùng để xem ngày mà user input vào có sau ngày hôm nay hay không, nếu có thì trả về false
                return false;                           // ngược lại thì trả về true
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static String checkPhoneNumber (String Msg, String errorMsg){
        String phoneNumber;
        boolean checkLength;
        do {
            System.out.println (Msg );
            phoneNumber = sc.next ().trim ();
            if ( phoneNumber.matches ("^[0-9]{10,16}$"))
                return phoneNumber;
            else
                System.out.println (errorMsg );
        } while (true);

    }

    public static String checkEmailAddress(String Msg, String errorMsg){
        String EmailAddress;
        do {
            System.out.println (Msg );
            EmailAddress = sc.next ().trim ();
            if (!EmailAddress.isEmpty () && EmailAddress.matches ("^\\w+[A-Za-z0-9]*@[a-zA-Z]*[a-zA-Z.]*[a-zA-Z]$"))
                break;
            else
                System.out.println (errorMsg );
        } while (true);
        return EmailAddress;
    }

    public static int checkYearExp(String Msg, String errorMsg) {
        int yearOfExp;
        do {
            try {
                System.out.println ( Msg );
                yearOfExp = Integer.parseInt (sc.next().trim ());
                if ( yearOfExp >= 0 && yearOfExp <= 100 )
                    return yearOfExp;
            } catch (Exception e){
                System.out.println ( errorMsg );
            }
        } while (true);

    }

    public static String checkRankOfGraduation(String Msg, String errorMsg){
        String RankValue;
       final Set<String> RankSet = new HashSet<> (  );
        RankSet.add ("excellence");
        RankSet.add ("good");
        RankSet.add ("fair");
        RankSet.add ("poor");
        do {
            System.out.println (Msg );
            RankValue = sc.next ().trim ();
            if ( RankSet.contains (RankValue.toLowerCase ( )) )
                return RankValue.toUpperCase ();
            else
                System.out.println (errorMsg );
        } while (true);
    }

    public static String getString(String Msg, String errorMsg) {
        String InputString;
        do {
            System.out.println (Msg );
            InputString = sc.nextLine ().trim ();
            if (InputString.isEmpty ())
                System.out.println ( errorMsg );
            else return InputString;
        } while ( true );

    }

    private static void Swapping (double a, double b) {
        double tmp = a;
        a = b;
        b = tmp;
    }

    public static int getAnIntegerInRange (String Msg, String errorsMsg, int lower, int upper) {
        int Input;
        if ( lower > upper )
            Swapping (lower, upper);
        do {
            try {
                System.out.println (Msg);
                Input = Integer.parseInt (sc.nextLine ());
                if ( Input < lower || Input > upper )
                    throw new Exception ();
                else return Input;
            } catch (Exception e){
                System.out.println (errorsMsg );
            }
        } while ( true );

    }

    public static double getANumber (String Msg, String errorsMsg) {
        double Input;
        do {
            try {
                System.out.println (Msg);
                Input = Double.parseDouble (sc.nextLine ());
                return Input;
            } catch (Exception e){
                System.out.println (errorsMsg );
            }
        } while ( true );

    }

    public static double getADoubleInRange (String Msg, String errorsMsg, Double lower, Double upper) {
        Double Input;
        if ( lower > upper )
            Swapping (lower, upper);
        do {
            try {
                System.out.println (Msg);
                Input = Double.parseDouble (sc.nextLine ());
                if (Input < lower || Input > upper) throw new Exception (  );
                return Input;
            } catch (Exception e){
                System.out.println (errorsMsg );
            }
        } while ( true );

    }




    public static void main(String[] args) throws ParseException {


    }


}
