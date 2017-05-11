
import java.util.Scanner;

public class Storage {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to inventory software)))");
        System.out.println("The list of things you can do:");
        System.out.println("1. Add items to your store.(add)\n2. Sale an item (sales).\n3. Buy more items if needed. (buy)");
        System.out.println("4. Display items based on name of item and based on popularity. (items)\n5. Display income. (income)\n6. Exit.");
        System.out.println("What would you like to do? (add/ sales/ buy/ items/ income/ exit)");
        String choice = sc.next(); //choice of commands
   
        
        Inventory inv = new Inventory();

        while(choice.equalsIgnoreCase("add")||choice.equalsIgnoreCase("sales") || choice.equalsIgnoreCase("buy") || choice.equalsIgnoreCase("items") || choice.equalsIgnoreCase("income"))
        {
            if (choice.equalsIgnoreCase("add")) //adding items to store
            {
                System.out.println("What would you like to add? (t-shirt/cup)");
                String item = sc.next(); 
                int quantity = Validator.getInt(sc, "Type the quantity of your item: ");
                double price = Validator.getDouble(sc, "Type the price of item: ");
                if (item.equalsIgnoreCase("t-shirt"))
                {
                    System.out.println("Type the size of t-shirt: ");
                    String size = sc.next();
                    Item next =  new T_shirt(quantity, price, 0, size);
                    inv.addItem(next, "t-shirt");
                }
                else if (item.equalsIgnoreCase("cup"))
                {
                    System.out.println("Type the model of cup: ");
                    String model = sc.next();
                    System.out.println("Type the substance of cup: ");
                    String substance = sc.next();
                    Item next =  new Cup(quantity, price, 0, model, substance);
                    inv.addItem(next, "cup");
                }  
                else
                {
                    System.out.println("You can't add this item. Only t-shirt or cup.");
                }
            }
            else if (choice.equalsIgnoreCase("sales")) //adding sales
            {
                System.out.println("What do you sale? (t-shirt/cup)");
                String item = sc.next();
                if (item.equalsIgnoreCase("t-shirt"))
                {
                    System.out.println("Type the size of t-shirt: ");
                    String size = sc.next();
                    inv.addSales(sc, size, item);
                }
                else if (item.equalsIgnoreCase("cup"))
                {
                    System.out.println("Type the model of cup: ");
                    String model = sc.next();
                    inv.addSales(sc, model, item);
                }
                else 
                {
                    inv.addSales(sc, "", item);
                }
            } 
            else if (choice.equalsIgnoreCase("buy")) //buying more quantity
            {
                System.out.println("What do you buy? (t-shirt/cup)");
                String item = sc.next();
                if (item.equalsIgnoreCase("t-shirt"))
                {
                    System.out.println("Type the size of t-shirt: ");
                    String size = sc.next();
                    System.out.println("How many items? ");
                    int quantity = sc.nextInt();
                    inv.buy(quantity, size, item);
                }
                 else if (item.equalsIgnoreCase("cup"))
                {
                    System.out.println("Type the model of cup: ");
                    String model = sc.next();
                    System.out.println("How many items? ");
                    int quantity = sc.nextInt();
                    inv.buy(quantity, model, item);
                }
                else 
                {
                    System.out.println("You can't buy this item. Try again.");
                }
            }
            else if (choice.equalsIgnoreCase("items"))// display items
            {
                System.out.println("What would you like to display? (t-shirt/cup)");
                String item = sc.next();
                if (item.equalsIgnoreCase("t-shirt"))
                {
                    System.out.println("Display items by (pop/name): ");
                    String display = sc.next();
                    if (display.equalsIgnoreCase("pop"))
                        inv.sortShirtByPop();
                    else if (display.equalsIgnoreCase("name"))
                        inv.sortShirtByName();
                    String displayItem = inv.displayItems(item);
                    System.out.println(displayItem);
                }
                else if (item.equalsIgnoreCase("cup"))
                {
                    System.out.println("Display items by (pop/name): ");
                    String display = sc.next();
                    if (display.equalsIgnoreCase("pop"))
                        inv.sortCupByPop();
                    else if (display.equalsIgnoreCase("name"))
                        inv.sortCupByName();
                    String displayItem = inv.displayItems(item);
                    System.out.println(displayItem);
                }  
                else 
                {
                    String displayItem = inv.displayItems(item);
                    System.out.println(displayItem);
                }
            }
            else if (choice.equalsIgnoreCase("income"))
            {
                System.out.println("What income would you like to display? (t-shirt/cup)");
                String item = sc.next();
                if (item.equalsIgnoreCase("t-shirt"))
                {
                    String displayInc = inv.displayIncome(item);
                    System.out.println(displayInc);
                }
                else if (item.equalsIgnoreCase("cup"))
                {
                    String displayInc = inv.displayIncome(item);
                    System.out.println(displayInc);
                }
                else 
                {
                    String displayInc = inv.displayIncome(item);
                    System.out.println(displayInc);
                }
            }
        System.out.println("What would you like to do? (add/ sales/ buy/ items/ income/ exit)");
        choice = sc.next(); //choice of commands
        }
    }}
