import java.io.*;
import java.util.*;


public class case_stats {
    public static void main(String[] args) {
        //Get user input
        int input = 0;
        Scanner sc= new Scanner(System.in);  
	    System.out.print("Enter number of cases to open: ");  

        try {
	        input = Integer.parseInt(sc.nextLine());   
        }
        catch (NumberFormatException ex){
            System.out.println("Must be a valid number!");
        }
        
        System.out.println(cost(input) + "\n" + open_cases(input));
    }


    /* Calculate odds
     * Blue = Mil-Spec, Purple = Restricted, Pink = Classified, Red = Covert, Gold = Rare Special
     * Calculation based on pre-determined odds: https://www.reddit.com/r/GlobalOffensive/comments/6zd9yx/perfect_world_csgo_has_finally_published_their/
     * Blue - 100 items - 79.92%
     * Purple - 20 items - 15.98%
     * Pink - 4 items - 3.2%
     * Red - 0.8 items - 0.64%
     * Yellow - 0.32 items - 0.26%
     */
    public static String open_cases(int input) {
        int blue = 0;
        int purple = 0;
        int pink = 0; 
        int red = 0;
        int gold = 0;

        double open_raw_value = 0;
        
        for (int i = 0; i < input; i++) {
            open_raw_value = Math.random();
            //System.out.println(open_raw_value);
            
            if (open_raw_value <= 0.7992) {
                blue++;
            }
            if (open_raw_value > 0.7992 && open_raw_value <= 0.959) {
                purple++;
            }
            if (open_raw_value > 0.959 && open_raw_value <= 0.991) {
                pink++;
            }
            if (open_raw_value > 0.991 && open_raw_value <= 0.9974) {
                red++;
            }
            if (open_raw_value > 0.9974 && open_raw_value <= 1) {
                gold++;
            }
        }

        return "Found " + blue + " Mil-Spec, " + purple + " Restricted, " +  pink + " Classified, " + red + " Covert and " + gold + " Rare Special items in " + input;
    }

    /*Calculate cost */
    public static String cost(int input) {
        double costUSD = input * 2.5;
        double costAUD = input * 3.5;
        String msg = ""; 

        if (input < 100) {
            msg = "Not that much...";
        }
        if (input >= 100 && input < 1000) {
            msg = "That's quite a bit!";
        }
        if (input >= 1000 && input < 10000) {
            msg = "Wow, that much on opening cases...thats insane";
        }
        if (input >= 10000) {
            msg = "So much money it makes my eyes cry.";
        }
        
        return "Total cost of keys is $" + costUSD + "USD and $" + costAUD + "AUD. " + msg;
    }
}
