

public class Cup extends Item {
    
//the instance variables
String model;
String substance;

//the constructor
public Cup(int quantity, double price, int sales, String model, String substance)
{
    super(quantity, price, sales);
    this.model = model;
    this.substance = substance;
}
public Cup(){}
public String getModel() {return model;}

public void setQuantity(String model) {this.model = model;}

public String getSubstance() {return substance;}

public void setSubstance(String substance) {this.substance = substance;}

}
