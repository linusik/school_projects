
import java.util.Scanner;


public class Validator {
    //get valid price
    public static double getDouble(Scanner sc, String prompt)
    {
        double d = 0.0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }
    //get valid quantity
    public static int getInt(Scanner sc, String prompt)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }
    
    //check if sales not less than quantity of items in inventory
    public static int getSales(Scanner sc, String promt, int quantity)
    {
        int sales = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(promt);
            sales = sc.nextInt();
            if (sales <= quantity)
            {
                isValid = true;
            }
            else
            {
                System.out.println("Error! You don't have such quantity of items. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return sales;
    }
       
}
