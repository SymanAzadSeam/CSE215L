// Clothing.java (Subclass)
package inventory;

public class Clothing extends Product 
{
    private String size;

    public Clothing(int id, String name, double price, String size)
    {
        super(id, name, price);
        this.size = size;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    @Override
    public void displayInfo()
    {
        System.out.println("Clothing - ID: " + getId() + ", Name: " + getName() + ", Price: $" + getPrice() + ", Size: " + size);
    }
}
