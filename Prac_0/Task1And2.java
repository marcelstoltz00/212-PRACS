import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Task1And2 {

    public boolean containsGenZSlang(String bio) {

        return bio.contains("no cap");
    }

    public boolean isSpecialLength(String bio) {
        return (bio.length() == 42);

    }

    public boolean distinct(String str) {
        if (str.length() < 2) {
            return false;
        }

        char first = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != first) {
                return true;
            }
        }

        return false;

    }

    public boolean isPalindrome(String str) {
        // two pointer method
        if (str.length() == 1 || str.length() == 0) {
            return false;
        }

        String lower = str.replaceAll(" ", "");// remove spaces
        lower = lower.toLowerCase();
        if (!distinct(lower)) {
            return false;
        }
        double half = Math.ceil((lower.length() * 1.0) / 2.0);

        for (int i = 0; i < half; i++) {
            char front = lower.charAt(i);
            char back = lower.charAt(lower.length() - i - 1);

            if (front != back) {
                return false;
            }

        }
        return true;

    }

    public boolean containsPalindrome(String bio) {
        for (int i = 0; i < bio.length(); i++) {
            for (int j = i; j < bio.length(); j++) {
                String sub = bio.substring(i, j + 1);
                if (isPalindrome(bio)) {
                    return true;
                }

            }
        }
        return false;

    }

    public boolean canAccept(String bio) {
        return (containsGenZSlang(bio) || isSpecialLength(bio) || containsPalindrome(bio));
    }

    /**
     * @param fileName
     * @return
     */
    public String listApplicantStatuses(String fileName) {
        String list="";    String output="";
        try {
            Scanner file = new Scanner(new FileReader(fileName));
            while(file.hasNext()){
                String line= file.nextLine();
                String[] splitup=line.split("#");
                String firstname =splitup[0];
                String surname = splitup[1];
                String bio = splitup[4];
            
                 output +=  firstname+" "+surname+" :\t";
                if (canAccept(bio)){
                    output += "accepted\n";
                }
                else
                {
                    output+= "not accepted\n";
                }






            }
            file.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } 

        return output;
    }

}
