import java.util.Stack;
import java.util.Scanner;

class Product {
    String brand;
    double price;

    public Product(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return brand + " - $" + price;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Stack<Product> cart = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to JAZHI cellhpone online Shop , We have every brand of cellphone.");
        System.out.println("How can we help you?");

        while (true) {
            System.out.println("Shopping Cart Menu:");
            System.out.println("1. Add to cart");
            System.out.println("2. Update cart");
            System.out.println("3. Delete from cart");
            System.out.println("4. View cart");
            System.out.println("5. Search cart");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("What Brand of cellphone do you like?: ");
                    String productBrand = scanner.nextLine();
                    System.out.print("How much can you offer?: ");
                    double productPrice = scanner.nextDouble();
                    cart.push(new Product(productBrand, productPrice));
                    System.out.println("Product added to the cart.");
                    break;


                case 2:
                    if (!cart.isEmpty()) {
                        System.out.println("Your current cart:");
                        for (Product product : cart) {
                            System.out.println(cart.indexOf(product) + ": " + product);
                        }
                        System.out.print("Do you want to update your cart? Please enter the index to update cart: ");
                        int updateIndex = scanner.nextInt();
                        scanner.nextLine();
                        if (updateIndex >= 0 && updateIndex < cart.size()) {
                            System.out.print("What Brand would you like to replace?: ");
                            String updatedBrand = scanner.nextLine();
                            System.out.print("Enter updated product price: ");
                            double updatedPrice = scanner.nextDouble();
                            Product updatedProduct = new Product(updatedBrand, updatedPrice);
                            cart.set(updateIndex, updatedProduct);
                            System.out.println("Product updated in the cart.");
                        } else {
                            System.out.println("Invalid index.");
                        }
                    } else {
                        System.out.println(
                                "Your Cart is empty. You can browse and look for product you want to check out.");
                    }
                    break;

                    
                case 3:
                    if (!cart.isEmpty()) {
                        System.out.println("Your current cart:");
                        for (Product product : cart) {
                            System.out.println(cart.indexOf(product) + ": " + product);
                        }
                        System.out.print("Enter the index of the product you want to delete: ");
                        int deleteIndex = scanner.nextInt();
                        if (deleteIndex >= 0 && deleteIndex < cart.size()) {
                            cart.remove(deleteIndex);
                            System.out.println("Product deleted from the cart.");
                        } else {
                            System.out.println("Invalid index.");
                        }
                    } else {
                        System.out.println("Cart is empty. Nothing to delete.");
                    }
                    break;


                case 4:
                    if (!cart.isEmpty()) {
                        System.out.println("Your current cart:");
                        for (Product product : cart) {
                            System.out.println(cart.indexOf(product) + ": " + product);
                        }
                    } else {
                        System.out.println("Cart is empty.");
                    }
                    break;

                    
                case 5:
                    System.out.print("What are you looking for? you can enter it's brand name: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    for (Product product : cart) {
                        if (product.brand.equalsIgnoreCase(searchName)) {
                            System.out.println("Product found in the cart: " + product);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Product not found in the cart.");
                    }
                    break;


                case 6:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Thank you for browsing, See you next time!.");
            }
        }
    }
}
