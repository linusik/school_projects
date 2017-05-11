
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.text.NumberFormat;


public class Inventory 
{
    //instance variables
    private ArrayList<T_shirt> shirtList = new ArrayList(); 
    private T_shirt t_shirt = new T_shirt();
    private ArrayList<Cup> cupList = new ArrayList(); 
    private Cup cup = new Cup();
   
    //constructor
    public Inventory()
    {      
    }
    
    //adding items
    public void addItem(Item next, String item)
    {
        if (item.equalsIgnoreCase("t-shirt"))
        {
            T_shirt shirt = (T_shirt)next;
            shirtList.add(shirt);
            System.out.print("Your t-shirt was added.\n");
        }
        else if (item.equalsIgnoreCase("cup"))
        {
            Cup cup = (Cup)next;
            cupList.add(cup);
            System.out.print("Your cup was added.\n");
        }
        else
        {
            System.out.println("You can't add this item.\n");
        }
    }
    //adding sales to inventory
    public void addSales(Scanner sc, String instVar, String item)
    {
        if (item.equalsIgnoreCase("t-shirt"))
        {
            String size = instVar;
            for (int i = 0; i < shirtList.size(); i++)
            {
                t_shirt = shirtList.get(i);
                if(t_shirt.getSize().equalsIgnoreCase(size))
                {
                    //check if sales less than quantity
                    int sales = Validator.getSales(sc, "How many items? ", t_shirt.getQuantity());
                    int quantity = t_shirt.getQuantity() - sales;
                    int sale = t_shirt.getSales() + sales;
                    //set sales and quantity
                    t_shirt.setQuantity(quantity);
                    t_shirt.setSales(sale);
                    System.out.println("The sales were added.\n");
                }
            }
        }
        else if (item.equalsIgnoreCase("cup"))
        {
            String model = instVar;
            for (int i = 0; i < cupList.size(); i++)
            {
                cup = cupList.get(i);
                if(cup.getModel().equalsIgnoreCase(model))
                {
                    //check if sales less than quantity using Validator class
                    int sales = Validator.getSales(sc, "How many items? ", t_shirt.getQuantity());
                    int quantity = cup.getQuantity() - sales;
                    int sale = cup.getSales() + sales;
                    // set sales and quantity
                    cup.setQuantity(quantity);
                    cup.setSales(sale);
                    System.out.println("The sales were added.\n");
                }
            }
        }
        else
        {
            System.out.println("You don't have such item in your storage.");
            System.out.println("Try again.");
        }
    }
    
    //buy more items to the store
     public void buy(int quantity, String instVar, String item)
     {
        if (item.equalsIgnoreCase("t-shirt"))
        {
            String size = instVar;
            for (int i = 0; i < shirtList.size(); i++)
            {
                t_shirt = shirtList.get(i);
                if(t_shirt.getSize().equalsIgnoreCase(size))
                {
                    int newQuantity = t_shirt.getQuantity() + quantity;
                    t_shirt.setQuantity(newQuantity); //set quantity
                    System.out.println("You bought items to your storage.");
                }
            }
        }
        else if (item.equalsIgnoreCase("cup"))
        {
            String model = instVar;
            for (int i = 0; i < cupList.size(); i++)
            {
                cup = cupList.get(i);
                if(cup.getModel().equalsIgnoreCase(model))
                {
                    int newQuantity = cup.getQuantity() + quantity;
                    cup.setQuantity(newQuantity); //set quantity
                    System.out.println("You bought items to your storage.");
                }
            }
        }
        else
        {
            System.out.println("You don't have such item in your storage.");
            System.out.println("Try again.");
        }
     }
    
    //display items to user
    public String displayItems(String item)
    {
        String answer = "The items weren't found.";
        if (item.equalsIgnoreCase("t-shirt"))
        {
            answer = "T-SHIRTS: \n" + "Size\tQt.\tPrice\tSales\n";
            for (int i = 0; i < shirtList.size(); i++)
            {
                t_shirt = shirtList.get(i);
                answer += t_shirt.getSize() + "\t"
                        + t_shirt.getQuantity() + "\t"
                        + t_shirt.getPrice() + "\t"
                        + t_shirt.getSales() + "\n";
            }
        }
        else if (item.equalsIgnoreCase("cup"))
        {
            answer = "CUPS: \n" + "Model\tSubstance\tQt.\tPrice\tSales\n";
            for (int i = 0; i < cupList.size(); i++)
            {
                cup = cupList.get(i);
                answer += cup.getModel() + "\t"
                        + cup.getSubstance() + "\t"
                        + cup.getQuantity() + "\t"
                        + cup.getPrice() + "\t"
                        + cup.getSales() + "\n";
            }
        }
        return answer;
    }
    
    //count and display incme to user
    public String displayIncome(String item)
    {
         String answer = "The items weren't found. The income can't be calculated.";
         if (item.equalsIgnoreCase("t-shirt"))
         {
             double income = t_shirt.getPrice() * t_shirt.getSales();
             answer = "The totel income for t_shirts:\t" 
                     + NumberFormat.getCurrencyInstance().format(income);
         }
         else if (item.equalsIgnoreCase("cup"))
         {
             double income = cup.getPrice() * cup.getSales();
             answer = "The totel income for cups:\t" 
                     + NumberFormat.getCurrencyInstance().format(income);
         }
         return answer;
    }
    
    //sort t-shirt inventory by name
    public void sortShirtByName()
    {
        Collections.sort(shirtList, new Comparator<T_shirt>() 
        {
            @Override
            public int compare(T_shirt t_shirt1, T_shirt t_shirt2) 
            {
                return t_shirt1.getSize().compareTo(t_shirt2.getSize());
            }
        });
    
    }
    //sort cup inventory by name
    public void sortCupByName()
    {
         Collections.sort(cupList, new Comparator<Cup>() 
        {
            @Override
            public int compare(Cup cup1, Cup cup2) 
            {
                return cup1.getModel().compareTo(cup2.getModel());
            }
        });
    } 
    //sort t-shirt inventory by popularity
    public void sortShirtByPop()
    {
        Collections.sort(shirtList, new Comparator<T_shirt>() 
        {
            @Override
            public int compare(T_shirt shirt1, T_shirt shirt2) 
            {
               int result = 0;
               if (shirt1.getSales() > shirt2.getSales())
                   result = 1;
               else if (shirt1.getSales() < shirt2.getSales())
                   result = -1;
               else if (shirt1.getSales() == shirt2.getSales())
                   result = 0;
               return result;
               
            }
        });
    }
    //sort cup inventory by popularity
    public void sortCupByPop()
    {
        Collections.sort(cupList, new Comparator<Cup>() 
        {
            @Override
            public int compare(Cup cup1, Cup cup2) 
            {
               int result = 0;
               if (cup1.getSales() > cup2.getSales())
                   result = 1;
               else if (cup1.getSales() < cup2.getSales())
                   result = -1;
               else if (cup1.getSales() == cup2.getSales())
                   result = 0;
               return result;             
            }
        });
    }
}


