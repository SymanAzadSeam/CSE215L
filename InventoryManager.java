package inventory;
import exceptions.ProductNotFoundException;

import java.util.*;


public class InventoryManager {
    private List<Product> products = new ArrayList<>();
    private int nextID = 1;

    public void addProduct(Product product)
    {
        product.setId(nextID);
        products.add(product);
        nextID++;
    }

    public void displayProducts()
    {
        for (Product product : products)
        {
            product.displayInfo();
        }

        
    }

    public void deleteProduct(int id) throws ProductNotFoundException 
    {
        Product productToDelete = null;
        for (Product product : products)
        {
            if (product.getId() == id)
            {
                productToDelete = product;
                break;
            }
        }

        if (productToDelete != null) 
        {
            products.remove(productToDelete);
        } else 
        {
            throw new ProductNotFoundException("Product with ID " + id + " not found.");
        }
        
        
    }

    public Product searchProduct(int id) throws ProductNotFoundException 
    {
        for (Product product : products)
        {
            if (product.getId() == id) 
            {
                return product;
            }
        }

        throw new ProductNotFoundException("Product with ID " + id + " not found.");
        
        
        
        
    }

    public void editProduct(int id, String name, double price) throws ProductNotFoundException
    {
        for (Product product : products)
        {
            if (product.getId() == id)
            {
                product.setName(name);
                product.setPrice(price);
                return;
            }
        }

        throw new ProductNotFoundException("Product with ID " + id + " not found.");
        
    }

   

    public static void main(String[] args)
    {
        InventoryManager manager = new InventoryManager();

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
        	System.out.println("Press any key to continue, press 0 to TERMINATE ");
            
            int exit = scanner.nextInt();
            		
            if(exit == 0)
            	break;
            
            System.out.println("\nInventory Manag1ement System \n");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Delete Product");
            System.out.println("4. Search Product");
            System.out.println("5. Edit Product");

            System.out.print("Select an option: ");
            int option = scanner.nextInt();

            switch (option) 
            {
                case 1:
                    System.out.print("Enter product type (1 for Electronics, 2 for Clothing, 3 for Food): ");
                    int productType = scanner.nextInt();
                    System.out.print("Enter product name: ");
                    String name = scanner.next();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();

                    Product product = null;
                    switch (productType) {
                        case 1:
                            System.out.print("Enter brand for Electronics: ");
                            String brand = scanner.next();
                            product = new Electronics(0, name, price, brand);
                            break;
                        case 2:
                            System.out.print("Enter size for Clothing: ");
                            String size = scanner.next();
                            product = new Clothing(0, name, price, size);
                            break;
                        case 3:
                            System.out.print("Enter expiration date for Food: ");
                            String expirationDate = scanner.next();
                            product = new Food(0, name, price, expirationDate);
                            break;
                        default:
                            System.out.println("Invalid product type.");
                            break;
                    }

                    if (product != null) 
                    {
                        manager.addProduct(product);
                        System.out.println("Product added with ID " + (manager.nextID - 1));
                    }
                    break;
                case 2:
                    manager.displayProducts();
                    break;
                case 3:
                    System.out.print("Enter product ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    try 
                    {
                        manager.deleteProduct(idToDelete);
                        System.out.println("Product with ID " + idToDelete + " deleted.");
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter product ID to search: ");
                    int idToSearch = scanner.nextInt();
                    try 
                    {
                        Product foundProduct = manager.searchProduct(idToSearch);
                        System.out.println("Product found:");
                        foundProduct.displayInfo();
                    } catch (ProductNotFoundException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Enter product ID to edit: ");
                    int idToEdit = scanner.nextInt();
                    System.out.print("Enter new product name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new product price: ");
                    double newPrice = scanner.nextDouble();
                    try 
                    {
                        manager.editProduct(idToEdit, newName, newPrice);
                        System.out.println("Product with ID " + idToEdit + " edited.");
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
              
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            
            
            
        }
    }
}
