
public abstract class Item {
    
//the instance variables
private int quantity;
private double price;
private int sales;

//the constructor
public Item(int quantity, double price, int sales)
{
this.quantity = quantity;
this.price = price;
this.sales = sales;
}

public Item(){}
public int getQuantity() {return quantity;}

public void setQuantity(int quantity) {this.quantity = quantity;}

public double getPrice() {return price;}

public void setPrice(double price) {this.price = price;}

public int getSales() {return sales;}

public void setSales(int sales) {this.sales = sales;}


}
