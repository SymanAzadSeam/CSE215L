// Food.java (Subclass)
package inventory;

public class Food extends Product 
{
    private String expirationDate;

    public Food(int id, String name, double price, String expirationDate)
    {
        super(id, name, price);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate()
    {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate)
    {
        this.expirationDate = expirationDate;
    }

    @Override
    public void displayInfo() 
    {
        System.out.println("Food - ID: " + getId() + ", Name: " + getName() + ", Price: $" + getPrice() + ", Expiration Date: " + expirationDate);
    }
}
