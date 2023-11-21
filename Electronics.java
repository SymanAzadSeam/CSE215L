// Electronics.java (Subclass)
package inventory;

public class Electronics extends Product
{
    private String brand;

    public Electronics(int id, String name, double price, String brand)
    {
        super(id, name, price);
        this.brand = brand;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    @Override
    public void displayInfo()
    {
        System.out.println("Electronics - ID: " + getId() + ", Name: " + getName() + ", Price: $" + getPrice() + ", Brand: " + brand);
    }
}
