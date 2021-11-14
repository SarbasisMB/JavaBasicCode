import java.util.*;
import java.util.Random;

class CaptchaCheck
{
    public static String getString()
    {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        String mainString = "abcd98765VWXY432efmnopHIxyz01AJKLrstuvwBCDEqFGMNOPQghijklRSxyz01ATUZ";
        String finalString="";
        //using for loop to generate the captcha in character and then storing it in the form of string
        for(int i=0;i<6;i++)
        {
            int n = rnd.nextInt(mainString.length());
            char c = mainString.charAt(n);
            finalString = finalString + c;
        }
        return finalString;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int chances = 0;//this will count the number of chances user have got
        int i = 3; //user will have 3 chances to verify their captcha
        System.out.println("You have only 3 trials to verify captcha.\n");
        //using while loop we will let the user verify their captcha
        while(chances<3)
        {   
            System.out.println("Attempt "+(chances+1));//this will show how many attempts user have made
            String callString = getString();//calling the getString object to get a captcha generated
            System.out.println("This is a captcha==> "+callString);
            System.out.println("Enter the above captcha to verify: ");
            String checkString = sc.nextLine();
            // System.out.println(checkString);
            //checking if the captcha entered by the user is correct or wrong
            if(callString.equals(checkString))
            {
                System.out.println("Captcha Verified, now you can proceed ahead.");
                break;
            }
            else
            {
                //in order to prevent the printing wrong information, another if statement is made
                if(i==1)
                {
                    System.out.println("\nYou have entered wrong captcha multiple times, come back later.\n");
                }
                else
                {
                    System.out.println("\nWrong captcha, you have more ==> "+(i-1)+" <== chances left\n");
                }
            }
            chances++;
            i--;
        }
    }
}