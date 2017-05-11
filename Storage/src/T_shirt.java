


public class T_shirt extends Item{
        
//the instance variables
String size;

//the constructor
public T_shirt(int quantity, double price, int sales, String size)
{
    super(quantity, price, sales);
    this.size = size;
}

public T_shirt(){}

public String getSize() {return size;}

public void setSize(String size) {this.size = size;}

}
